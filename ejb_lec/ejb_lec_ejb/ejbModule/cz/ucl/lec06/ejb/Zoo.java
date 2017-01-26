package cz.ucl.lec06.ejb;

import java.util.Date;

import javax.ejb.Remote;

@Remote
public interface Zoo {
	 //Vrací otevírací dobu jako text, např. "10:00-12:00, 12:30-18:00"
	 public String getOpeningHours(Date day);

	 //Provede platbu kartou, vrací rezervační kód vstupenky
	 public String buyTicket(Date day, String customerName, String creditCardNumber,
	                         String creditCardValidity) throws PaymentFailedException;

} 
