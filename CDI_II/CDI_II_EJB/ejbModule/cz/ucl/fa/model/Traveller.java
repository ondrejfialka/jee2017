package cz.ucl.fa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Traveller
 * 
 */
@Entity
public class Traveller implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Contract contract;
	
	private String firstName;
	private String surname;
	private String idNumber;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	private static final long serialVersionUID = 1L;

	public Traveller() {
		super();
	}
	
	public Long getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	
}
