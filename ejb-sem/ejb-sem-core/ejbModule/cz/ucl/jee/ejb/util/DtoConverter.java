package cz.ucl.jee.ejb.util;

import cz.ucl.jee.model.Hotel;
import cz.ucl.jee.model.Room;
import cz.ucl.jee.dto.HotelDTO;
import cz.ucl.jee.dto.RoomDTO;

public class DtoConverter {
	
	
	public static HotelDTO getHotelDTO(Hotel hotel){
		HotelDTO hotelDto = new HotelDTO();
		
		hotelDto.setName(hotel.getName());
		hotelDto.setDescription(hotel.getDescription());
		hotelDto.setLocation(hotel.getLocation());
		hotelDto.setId(hotel.getId());
		return hotelDto;
	}
	
	public static Room getRoom(RoomDTO roomDTO){
		Room room = new Room();
		
		room.setBeds(roomDTO.getBeds());
		room.setDescription(roomDTO.getDescription());
		room.setFloor(roomDTO.getFloor());
		room.setNumber(roomDTO.getNumber());
		
		return room;
	}
	

}
