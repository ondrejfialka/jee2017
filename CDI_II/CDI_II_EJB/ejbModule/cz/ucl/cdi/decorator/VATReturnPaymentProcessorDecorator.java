package cz.ucl.cdi.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import cz.ucl.cdi.bean.Payment;
import cz.ucl.cdi.bean.PaymentProcessor;

@Decorator
public class VATReturnPaymentProcessorDecorator implements PaymentProcessor {
	@Inject @Delegate @Any private PaymentProcessor processor;
	
	@Override
	public void pay(Payment p, Double price) {
		System.out.println("VATReturnPaymentProcessorDecorator is being executed for the price of " + price);
		if (p.getCountry() != null && p.getCountry().isInEU()) {
		    System.out.println("Payment for an EU-resident");
		    processor.pay(p, price);
		}
		else {
		    System.out.println("Payment for an resident of a non-EU country (without VAT)");
		    processor.pay(p, price * 0.84);
		}
		System.out.println("VATReturnPaymentProcessorDecorator is done");
	}

}
