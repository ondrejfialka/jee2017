package cz.ucl.jee.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.ucl.jee.model.Hotel;
import cz.ucl.jee.model.Room;
import cz.ucl.jee.model.Stay;
import cz.ucl.jee.ejb.util.DtoConverter;
import cz.ucl.jee.dto.HotelDTO;

@Remote(ReservationManager.class)
@Stateless
public class ReservationManagerBean implements ReservationManager {
	@PersistenceContext(unitName = "BlueResortsDS")
	private EntityManager em;
	
	@EJB
	ReservationDAO reservationDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<HotelDTO> findHotels(String location) {
		List<Hotel> hotels = reservationDAO.findHotels(location);
		List<HotelDTO> result = new ArrayList<HotelDTO>();
		for (Hotel h: hotels){
			result.add(DtoConverter.getHotelDTO(h));
		}
		return result;
	}	

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String createReservation(String hotelName, String customerName,
			int bedCount, Date from, Date to)
			throws NoRoomAvailableException {

		// Najdi pokoje
		String queryText = "SELECT r FROM Room r WHERE r.hotel.name = :hotelName AND r.beds >= :bedCount AND NOT EXISTS (" +
				"  SELECT s FROM Stay s WHERE s.room = r AND (" +
				"    (s.dayFrom > :dateFrom AND s.dayFrom < :dateTo) OR " +
				"    (s.dayTo > :dateFrom AND s.dayTo <:dateTo) OR " +
				"    (:dateFrom > s.dayFrom AND :dateFrom < s.dayTo) OR " +
				"    (:dateTo > s.dayFrom AND :dateTo < s.dayTo) " +
				"  ) " +
				") ORDER BY r.beds ASC";
		List<Room> availableRooms = (List<Room>) em.createQuery(queryText)
				.setParameter("hotelName", hotelName).setParameter("bedCount",
						bedCount).setParameter("dateFrom", from).setParameter(
						"dateTo", to).getResultList();

		// Založ rezervaci
		
		if(availableRooms.size() == 0) {
			throw new NoRoomAvailableException();
		} else {
			Room room = availableRooms.get(0);
			Stay stay = new Stay();
			stay.setCustomerName(customerName);
			stay.setDayFrom(from);
			stay.setDayTo(to);
			stay.setRoom(room);
			stay.setReservationCode(Long.toString(Math.abs((new Random()).nextLong())));
			em.persist(stay);			
			return stay.getReservationCode();
		}		
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cancelReservation(String reservationCode)
			throws NoCancellationException {
		// Ověř čas do začátku pobytu
		Stay stay = (Stay) em.createNamedQuery("Stay.findByReservationCode")
				.setParameter("reservationCode", reservationCode)
				.getSingleResult();
		Date now = new Date();
		long daysToStart = (stay.getDayFrom().getTime() - now.getTime())
				/ (24 * 3600 * 1000);
		if (daysToStart < 7) {
			throw new NoCancellationException("Too late, only " + daysToStart
					+ " before start of your stay (minimum 7 to cancel)");
		} else {
			em.remove(stay);
		}
	}

}
