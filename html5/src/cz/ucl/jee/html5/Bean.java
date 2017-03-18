package cz.ucl.jee.html5;

import javax.enterprise.inject.Model;

@Model
public class Bean {

	private String email;
	private Long number;
	private Double range;
	
	public void submit(){
		System.out.println(email + " " + number + " " + range);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Double getRange() {
		return range;
	}

	public void setRange(Double range) {
		this.range = range;
	}
	
}
