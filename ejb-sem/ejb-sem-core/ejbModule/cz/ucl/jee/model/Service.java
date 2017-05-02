package cz.ucl.jee.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import cz.ucl.jee.model.types.ServiceType;

@Entity
@SuppressWarnings("serial")
public class Service implements Serializable {

	@Id
	@GeneratedValue
	private Long id;	
	
	private String name;
	private String description;
	private ServiceType type;
	
	@ManyToOne
	private Hotel hotel;

	public Service() {
		super();
	}

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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
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
