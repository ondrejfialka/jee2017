package cz.ucl.jee.ejb;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import cz.ucl.jee.model.Hotel;
import cz.ucl.jee.model.Room;
import cz.ucl.jee.dto.RoomDTO;
import cz.ucl.jee.ejb.util.DtoConverter;

@Remote(HotelManager.class)
@Stateful
@Interceptors({ApplicationLogInterceptor.class})
public class HotelManagerBean implements HotelManager {
	@EJB
	ApplicationLog appLog;
	
	private Hotel selectedHotel;
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	/*@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<HotelDTO> listHotels() {
		return em.createQuery("SELECT h FROM Hotel h").getResultList();
	}*/
	
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void selectHotel(Long id) {
		selectedHotel = em.find(Hotel.class, id);
		
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addRoom(RoomDTO roomDto) {		
		Room room = DtoConverter.getRoom(roomDto);
		room.setHotel(selectedHotel);
		appLog.logAccess("Add a room",room.toString());
		em.persist(room);
	}

/*	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void changeRoom(Room room) {
		em.merge(room);
	}	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeRoom(Room room) {
		Room mergedRoom = em.merge(room);
		selectedHotel.getRooms().remove(mergedRoom);
		em.remove(mergedRoom);
	}	*/
	
	@Remove
	public void closeHotel() {
		selectedHotel = null;
	}

}
