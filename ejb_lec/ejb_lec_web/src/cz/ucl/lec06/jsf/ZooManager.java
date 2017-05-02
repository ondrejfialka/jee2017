package cz.ucl.lec06.jsf;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import cz.ucl.lec06.ejb.PaymentFailedException;
import cz.ucl.lec06.ejb.Zoo;

@Named("zooManager")
@ViewScoped
public class ZooManager implements Serializable {
	@EJB
	private Zoo zoo;

	private Date visitDay;
	private String customerName;
	private String creditCardNumber;
	private String creditCardValidity;

	private String ticketCode;

	public Date getVisitDay() {
		return visitDay;
	}

	public void setVisitDay(Date visitDay) {
		this.visitDay = visitDay;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardValidity() {
		return creditCardValidity;
	}

	public void setCreditCardValidity(String creditCardValidity) {
		this.creditCardValidity = creditCardValidity;
	}

	public String getTicketCode() {
		return ticketCode;
	}

	public void buyTicket() {
		try {
			ticketCode = zoo.buyTicket(visitDay, customerName,
					creditCardNumber, creditCardValidity);
		} catch (PaymentFailedException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Ticket payment failed", e.getMessage()));			
		}		
	}

}
