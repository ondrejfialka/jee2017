package cz.ucl.cdi.bean;

import javax.enterprise.context.ApplicationScoped;

import cz.ucl.cdi.annotation.CreditCard;
import cz.ucl.cdi.annotation.MasterCard;
import cz.ucl.cdi.annotation.Visa;

@ApplicationScoped
@CreditCard
@MasterCard
public class MasterCardPaymentProcessor extends CreditCardPaymentProcessor {
	public MasterCardPaymentProcessor() {
		System.out.println("MasterCardPaymentProcessor constructor");
	}

	public void pay(Payment p, Double price) {
		System.out.println("MasterCardPaymentProcessor.pay(), price: " + price);
	}
}
