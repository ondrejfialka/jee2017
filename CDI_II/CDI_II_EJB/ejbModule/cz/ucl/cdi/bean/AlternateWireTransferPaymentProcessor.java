package cz.ucl.cdi.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import cz.ucl.cdi.annotation.WireTransfer;

@ApplicationScoped
@WireTransfer
@Alternative
public class AlternateWireTransferPaymentProcessor implements WireTransferPaymentProcessor {
	 public AlternateWireTransferPaymentProcessor() {
		  System.out.println("Constructor of AlternateWireTransferPaymentProcessor");
	  }
	 
	 public void pay(Payment p, Double price) {
		  System.out.println("AlternateWireTransferPaymentProcessor.pay(), price " + price);
	  }
}
