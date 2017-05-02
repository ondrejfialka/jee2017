package cz.ucl.jee.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Room implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	
	private String number;
	private Integer beds;
	private Integer floor;
	private String description;
	
	@ManyToOne
	private Hotel hotel;
	
	public Long getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getBeds() {
		return beds;
	}
	public void setBeds(Integer beds) {
		this.beds = beds;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@Override
	public String toString() {
		return "Room no. " + number + " on floor " + floor + " with " + beds + " bed(s)";
	}	
	
	
	
}