package cz.ucl.jee.storage.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries( { 
	 @NamedQuery(name = "findByFilter", query = "SELECT i FROM Item i WHERE "
	 		+ "(:weightTo is null or i.weight < :weightTo) "
	 		+ "AND (:weightFrom is null or i.weight > :weightFrom) "
	 		+ "AND (:name is null or i.name = :name)" )
	})
@SequenceGenerator(name="code_seq", initialValue=1, allocationSize=100)
public class Item {
	
	public static final String FIND_BY_FILTER =  "findByFilter";
	public static final String FILTER_WEIGHT_TO =  "weightTo";
	public static final String FILTER_WEIGHT_FROM =  "weightFrom";
	public static final String FILTER_NAME =  "name";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="code_seq")
	private Long code;
	
	private String name;
	private String description;
	private Double weight;
	
	@Temporal(TemporalType.DATE)
	private Date storageDate;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStorageDate() {
		return storageDate;
	}

	public void setStorageDate(Date storageDate) {
		this.storageDate = storageDate;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
}
