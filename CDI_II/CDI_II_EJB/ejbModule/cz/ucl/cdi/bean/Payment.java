package cz.ucl.cdi.bean;

import java.io.Serializable;

import javax.enterprise.inject.Model;

@Model
public class Payment implements Serializable {
	private String creditCardNo;
	private String creditCardValidity;
	private String creditCardOwnerName;
	private PaymentType type;
	private CountryOfResidence country;

	public Payment() {
		System.out.println("Constructor of Payment");
	}

	public String getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public String getCreditCardValidity() {
		return creditCardValidity;
	}

	public void setCreditCardValidity(String creditCardValidity) {
		this.creditCardValidity = creditCardValidity;
	}

	public String getCreditCardOwnerName() {
		return creditCardOwnerName;
	}

	public void setCreditCardOwnerName(String creditCardOwnerName) {
		this.creditCardOwnerName = creditCardOwnerName;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

    public CountryOfResidence getCountry() {
        return country;
    }

    public void setCountry(CountryOfResidence country) {
        this.country = country;
    }		
}