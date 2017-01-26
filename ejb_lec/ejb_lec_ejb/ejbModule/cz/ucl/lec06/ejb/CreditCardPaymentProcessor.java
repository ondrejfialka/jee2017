package cz.ucl.lec06.ejb;

import javax.ejb.Local;

@Local
public interface CreditCardPaymentProcessor {

	String processPayment(Double ticketPrice, String customerName,
			String creditCardNumber, String creditCardValidity) throws PaymentFailedException;

}
