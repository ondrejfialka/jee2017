package cz.ucl.jee.dto;

import java.io.Serializable;

import cz.ucl.jee.model.types.ServiceType;


public class ServiceDTO implements Serializable{
private Long id;	
	
	private String name;
	private String description;
	private ServiceType type;
	
	private HotelDTO hotel;

	public Long getId() {
		return this.id;
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

	public ServiceType getType() {
		return this.type;
	}

	public void setType(ServiceType type) {
		this.type = type;
	}	

	public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		String result = "";		
		result += getName();
		if (getHotel()!=null) {
			result += " [" ;
			result += getHotel().toString();
			result += "]";
		}
		
		return result;
	}
}
