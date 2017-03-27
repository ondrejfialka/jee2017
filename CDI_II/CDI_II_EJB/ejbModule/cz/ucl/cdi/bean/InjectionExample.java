package cz.ucl.cdi.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cz.ucl.cdi.annotation.Visa;

@ApplicationScoped
@Named
public class InjectionExample {
	
	private CreditCardPaymentProcessor processor;
	
	@Inject
	public InjectionExample(@Visa CreditCardPaymentProcessor processor){
		this.processor = processor;
	}
	
	public String getName(){
		return "";
	}

}
