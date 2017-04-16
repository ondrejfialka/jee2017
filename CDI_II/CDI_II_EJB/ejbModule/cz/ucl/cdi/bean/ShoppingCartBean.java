package cz.ucl.cdi.bean;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.inject.Named;

import cz.ucl.cdi.annotation.CreditCard;
import cz.ucl.cdi.annotation.MasterCard;
import cz.ucl.cdi.annotation.Monitored;
import cz.ucl.cdi.annotation.Visa;
import cz.ucl.cdi.annotation.WireTransfer;

@SessionScoped
@Named("cart")
public class ShoppingCartBean implements ShoppingCart, Serializable {
    @Inject
    private Payment payment;

    @Inject
    @CreditCard
    @Visa
    private PaymentProcessor ccPaymentProcessor;
    
    @Inject
    @WireTransfer
    private PaymentProcessor transferPaymentProcessor;

    @Monitored
    public void checkout() {
        if (payment.getType() == PaymentType.CREDIT_CARD) {
            ccPaymentProcessor.pay(payment, 10.0);            
        } else if(payment.getType() == PaymentType.WIRE_TRANSFER){  
        	transferPaymentProcessor.pay(payment, 10.0);
        }
    }
}
