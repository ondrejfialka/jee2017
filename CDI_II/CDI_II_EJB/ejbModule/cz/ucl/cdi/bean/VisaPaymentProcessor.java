package cz.ucl.cdi.bean;

import javax.enterprise.context.ApplicationScoped;

import cz.ucl.cdi.annotation.CreditCard;
import cz.ucl.cdi.annotation.Visa;

@ApplicationScoped
@CreditCard
@Visa
public class VisaPaymentProcessor extends CreditCardPaymentProcessor {
	public VisaPaymentProcessor() {
		System.out.println("VisaPaymentProcessor constructor");
	}

	public void pay(Payment p, Double price) {
		System.out.println("VisaPaymentProcessor.pay()");
	}
}
