package cz.ucl.jee.ejb;

import cz.ucl.jee.dto.RoomDTO;

public interface HotelManager {
	//public List<HotelDTO> listHotels();	
	public void selectHotel(Long id);
	
	//Potřebuje znát stav (vybraný hotel)
	public void addRoom(RoomDTO room);
	/*public void changeRoom(RoomDTO room);
	public void removeRoom(RoomDTO roosm);*/
	
	public void closeHotel();
}
