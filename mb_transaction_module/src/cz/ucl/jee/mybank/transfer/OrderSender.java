package cz.ucl.jee.mybank.transfer;

import cz.ucl.jee.mybank.entity.PaymentOrder;

public interface OrderSender {

	 void sendPaymentOrder(PaymentOrder order);
}
