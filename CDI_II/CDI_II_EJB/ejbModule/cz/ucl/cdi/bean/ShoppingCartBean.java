package cz.ucl.cdi.bean;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.inject.Named;

import cz.ucl.cdi.annotation.MasterCard;
import cz.ucl.cdi.annotation.Monitored;

@SessionScoped
@Named("cart")
public class ShoppingCartBean implements ShoppingCart, Serializable {
    @Inject
    private Payment payment;

    @Inject
    @Any
    private Instance<PaymentProcessor> paymentProcessorSource;

    @Monitored
    public void checkout() {
        if (payment.getType() == PaymentType.CREDIT_CARD) {
            Instance<CreditCardPaymentProcessor> found = 
            		paymentProcessorSource.select(CreditCardPaymentProcessor.class, new AnnotationLiteral<MasterCard>(){});
            if (!found.isAmbiguous() && !found.isUnsatisfied()) {
                found.get().pay(payment, 30.0d);
            } else {
                Instance<CreditCardPaymentProcessor> ccFound = 
                		paymentProcessorSource.select(CreditCardPaymentProcessor.class);
                for (PaymentProcessor pp : ccFound) {
                    pp.pay(payment, 30.0d);
                }
            }
        } else if(payment.getType() == PaymentType.WIRE_TRANSFER){  
            Instance<WireTransferPaymentProcessor> pInst = paymentProcessorSource.select(WireTransferPaymentProcessor.class);
            pInst.get().pay(payment, 30.0d);
        }
    }
}
