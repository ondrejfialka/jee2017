package cz.ucl.jee.ejb;

import java.util.Date;
import java.util.List;

import cz.ucl.jee.dto.HotelDTO;

public interface ReservationManager {
	public List<HotelDTO> findHotels(String location);

	public String createReservation(String hotelName, String customerName,
			int bedCount, Date from, Date to)
			throws NoRoomAvailableException;
	
	public void cancelReservation(String reservationCode) throws NoCancellationException;
}
