package cz.ucl.cdi.bean;

import javax.enterprise.context.ApplicationScoped;

import cz.ucl.cdi.annotation.Monitored;
import cz.ucl.cdi.annotation.WireTransfer;

@ApplicationScoped
@WireTransfer
@Monitored
public class RegularWireTransferPaymentProcessor implements WireTransferPaymentProcessor {
	 public RegularWireTransferPaymentProcessor() {
		  System.out.println("Constructor of RegularWireTransferPaymentProcessor");
	  }
	 
	 public void pay(Payment p, Double price) {
		  System.out.println("RegularWireTransferPaymentProcessor.pay(), price " + price);
	  }
}
