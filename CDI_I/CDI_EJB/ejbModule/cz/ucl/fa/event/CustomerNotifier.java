package cz.ucl.fa.event;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

import cz.ucl.fa.model.Contract;

@SessionScoped
public class CustomerNotifier implements Serializable {
  public void notifyCustomer(@Observes(during=TransactionPhase.AFTER_COMPLETION) TripPurchaseCompleted tripCompletedEvent) {
	Contract c = tripCompletedEvent.getContract();
    System.out.println("The customer will be notified about the contract for " + c.getHoliday().getName() + 
    		" and " + c.getTravellers().size() + " travellers.");
  }
}