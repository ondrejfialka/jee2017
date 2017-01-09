package cz.ucl.jee.mybank.security;

import java.math.BigDecimal;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import cz.ucl.jee.mybank.accounts.AccountBlackList;
import cz.ucl.jee.mybank.entity.PaymentOrder;
import cz.ucl.jee.mybank.transfer.OrderSender;

@Decorator
public class FraudProtectionDecorator implements OrderSender {

	public static BigDecimal MAX_AMOUNT = new BigDecimal(1000000);
	
	@Inject
	@Any
	@Delegate
	OrderSender orderSender;
	
	@Inject
	AccountBlackList blackList;
	
	public void sendPaymentOrder(PaymentOrder order) {
		
		if(blackList.isAccountOnList(order.getCreditAccount())){
			System.out.println("Amount too large, transaction denied.");
			return;
		}
				
		if (order.getAmount().compareTo(MAX_AMOUNT) > 0){
			System.out.println("Amount too large, transaction denied.");
			return;
		}
		
		orderSender.sendPaymentOrder(order);
	}

}
