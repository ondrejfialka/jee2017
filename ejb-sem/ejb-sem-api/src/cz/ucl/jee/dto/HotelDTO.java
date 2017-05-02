package cz.ucl.jee.dto;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class HotelDTO implements Serializable{
	
	private Long id;
	
	private String location;
	private String name;
	private String description;	
	
	private Set<ServiceDTO> services;	
	
	private Set<RoomDTO> rooms;

	public HotelDTO() {		
		services = new HashSet<ServiceDTO>();
	}   
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
 
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Set<ServiceDTO> getServices() {
		return services;
	}
	
	public void addService(ServiceDTO s) {
		services.add(s);
		s.setHotel(this);
	}
	
	public Set<RoomDTO> getRooms() {
		return rooms;
	}
	public void addRoom(RoomDTO r) {
		rooms.add(r);
		r.setHotel(this);
	}	
	
	@Override
	public String toString() {
		return getName() + ", " + getLocation();
	}
}
