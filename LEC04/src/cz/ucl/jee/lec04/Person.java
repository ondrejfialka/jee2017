package cz.ucl.jee.lec04;

import java.io.Serializable;

public class Person implements Serializable{

	private String firstName;
	private String surname;

	private String email;
	private RodneCislo rodneCislo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RodneCislo getRodneCislo() {
		return rodneCislo;
	}

	public void setRodneCislo(RodneCislo rodneCislo) {
		this.rodneCislo = rodneCislo;
	}

	@Override
	public String toString() {
		String result = firstName + " " + surname + " (RC: " + rodneCislo
				+ "), email: " + email;
		return result;
	}

}
