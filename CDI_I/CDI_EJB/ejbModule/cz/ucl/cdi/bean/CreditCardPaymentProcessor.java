package cz.ucl.cdi.bean;

import javax.enterprise.context.ApplicationScoped;

import cz.ucl.cdi.annotation.CreditCard;

@ApplicationScoped
@CreditCard
public class CreditCardPaymentProcessor implements PaymentProcessor {
	 public CreditCardPaymentProcessor() {
		  System.out.println("Constructor of CreditCardPaymentProcessor");
	  }
	 
	 public void pay(Payment p, Double price) {
		  System.out.println("CreditCardPaymentProcessor.pay()");
	  }
}
