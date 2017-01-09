package cz.ucl.cdi.bean;

import javax.enterprise.context.ApplicationScoped;

import cz.ucl.cdi.annotation.WireTransfer;

@ApplicationScoped
@WireTransfer
public class WireTransferPaymentProcessor implements PaymentProcessor {
	 public WireTransferPaymentProcessor() {
		  System.out.println("Constructor of WireTransferPaymentProcessor");
	  }
	 
	 public void pay(Payment p, Double price) {
		  System.out.println("WireTransferPaymentProcessor.pay()");
	  }
}
