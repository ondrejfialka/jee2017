package cz.ucl.cdi.bean;


public abstract class CreditCardPaymentProcessor implements PaymentProcessor {
	 public CreditCardPaymentProcessor() {
		  System.out.println("Constructor of CreditCardPaymentProcessor");
	  }	 	 
}
