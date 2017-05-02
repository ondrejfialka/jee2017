package cz.ucl.jee.ejb;

import java.util.List;

import cz.ucl.jee.model.Hotel;

public interface ReservationDAO {
	
	public List<Hotel> findHotels(String location);

}
