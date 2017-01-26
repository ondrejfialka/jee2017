package cz.ucl.lec06.ejb;

import java.util.Random;

import javax.ejb.Stateless;

@Stateless
public class CreditCardPaymentProcessorBean implements CreditCardPaymentProcessor {

	@Override
	public String processPayment(Double ticketPrice, String customerName,
			String creditCardNumber, String creditCardValidity)
			throws PaymentFailedException {	
		return "PMTN" + (new Random()).nextInt();
	}
	
}
