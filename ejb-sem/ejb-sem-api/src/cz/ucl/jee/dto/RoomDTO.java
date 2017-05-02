package cz.ucl.jee.dto;

import java.io.Serializable;


public class RoomDTO implements Serializable{
	private Long id;
	
	private String number;
	private Integer beds;
	private Integer floor;
	private String description;
	
	private HotelDTO hotel;
	
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
	public HotelDTO getHotel() {
		return hotel;
	}
	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}
	@Override
	public String toString() {
		return "Room no. " + number + " on floor " + floor + " with " + beds + " bed(s)";
	}	
}
