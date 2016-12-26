package cz.ucl.lec09.bean;

import javax.enterprise.context.ApplicationScoped;

import cz.ucl.lec09.annotation.WireTransfer;

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
