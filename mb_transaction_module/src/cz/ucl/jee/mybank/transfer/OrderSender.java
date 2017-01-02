package cz.ucl.jee.mybank.transfer;

import javax.enterprise.context.ApplicationScoped;

import cz.ucl.jee.mybank.entity.PaymentOrder;

@ApplicationScoped
public class OrderSender {
	
	
	public void sendPaymentOrder(PaymentOrder order){
		System.out.println("Sending money from " + order.getDebitAccount().getNumber() + " to " 
				+ order.getCreditAccount().getNumber());
	}

}
