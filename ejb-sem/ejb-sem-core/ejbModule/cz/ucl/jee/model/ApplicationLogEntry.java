package cz.ucl.jee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class ApplicationLogEntry implements Serializable {
	@SuppressWarnings("unused")
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	
	private String user;	
	private String action;
	private String object;
		
	public ApplicationLogEntry() {
		super();	
	}

	public ApplicationLogEntry(String action, String object, Date time,
			String user) {
		super();
		this.action = action;
		this.object = object;
		this.time = time;
		this.user = user;
	}

	public Date getTime() {
		return time;
	}

	public String getUser() {
		return user;
	}

	public String getAction() {
		return action;
	}

	public String getObject() {
		return object;
	}
}
