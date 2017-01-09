package cz.ucl.cdi.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import cz.ucl.cdi.annotation.CreditCard;
import cz.ucl.cdi.bean.Payment;
import cz.ucl.cdi.bean.PaymentProcessor;

@Decorator
public class FraudProtectionPaymentProcessorDecorator implements
		PaymentProcessor {
	@Inject @Delegate @CreditCard private PaymentProcessor processor;

	@Override
	public void pay(Payment p, Double price) {
		System.out.println("FraudProtectionPaymentProcessorDecorator is being executed for the price of " + price);
		
		if (p.getCreditCardNo() != null && "1234123412341234".equals(p.getCreditCardNo())) {
		    System.out.println("FRAUD DETECTED, PAYMENT STOPPED!");
		}
		else {
		   processor.pay(p, price);
		}
		
		System.out.println("FraudProtectionPaymentProcessorDecorator is done");
	}

}
