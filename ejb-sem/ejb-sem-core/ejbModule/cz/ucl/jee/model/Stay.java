package cz.ucl.jee.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="Stay.findByReservationCode", query="SELECT s FROM Stay s WHERE s.reservationCode = :reservationCode")
})
public class Stay implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;	
	
	@Temporal(TemporalType.DATE)
	private Date dayFrom;
	
	@Temporal(TemporalType.DATE)
	private Date dayTo;
	
	@ManyToOne
	private Room room;
	
	private String reservationCode;
	private String customerName;
	
	public Stay() {
		super();
	}
	
	public long getId() {
		return this.id;
	}

	public Hotel getHotel() {
		return room.getHotel();
	}   
	
	public Date getDayFrom() {
		return dayFrom;
	}
	public void setDayFrom(Date dayFrom) {
		this.dayFrom = dayFrom;
	}
	public Date getDayTo() {
		return dayTo;
	}
	public void setDayTo(Date dayTo) {
		this.dayTo = dayTo;
	}	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}	

	public String getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {	
		String result = "";
		
		result+=getHotel().toString();
		result+=", from ";		
		DateFormat df = DateFormat.getDateInstance();
		result+= df.format(getDayFrom());
		result+= " to ";
		result+= df.format(getDayTo());
		return result;
	}
   
}
