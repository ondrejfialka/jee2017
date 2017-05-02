package cz.ucl.jee.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@SuppressWarnings("serial")
@NamedQueries({
	@NamedQuery(name="Hotel.findByLocation", query="SELECT h FROM Hotel h WHERE h.location = :location")
})
public class Hotel implements Serializable {
	   
	@Id
	@GeneratedValue
	private Long id;
	
	private String location;
	private String name;
	private String description;
	
	@OneToMany(mappedBy="hotel")
	private Set<Service> services;
	
	@OneToMany(mappedBy="hotel")
	private Set<Room> rooms;

	public Hotel() {
		super();
		services = new HashSet<Service>();
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
	public Set<Service> getServices() {
		return services;
	}
	
	public void addService(Service s) {
		services.add(s);
		s.setHotel(this);
	}
	
	public Set<Room> getRooms() {
		return rooms;
	}
	public void addRoom(Room r) {
		rooms.add(r);
		r.setHotel(this);
	}	
	
	@Override
	public String toString() {
		return getName() + ", " + getLocation();
	}
	
	
   
}
