package cz.ucl.cdi.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cz.ucl.cdi.annotation.CreditCard;
import cz.ucl.cdi.annotation.WireTransfer;

@SessionScoped
@Named("cart")
public class ShoppingCartBean implements ShoppingCart, Serializable {
	@Inject
	private Payment payment;

	@Inject
	@CreditCard
	private PaymentProcessor ccPaymentProc;

	@Inject
	@WireTransfer
	private PaymentProcessor wireTransferPaymentProc;

	public void checkout() {
		switch (payment.getType()) {
		case CREDIT_CARD:
			ccPaymentProc.pay(payment, 30.0d);
			break;
		case WIRE_TRANSFER:
			wireTransferPaymentProc.pay(payment, 30.0d);
			break;
		}
	}
}
