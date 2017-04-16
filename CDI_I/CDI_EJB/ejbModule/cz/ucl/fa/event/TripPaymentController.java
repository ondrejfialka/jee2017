package cz.ucl.fa.event;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

import cz.ucl.fa.model.Contract;

public class TripPaymentController {	

	public void payForTrip(@Observes TripPurchaseCompleted tripCompletedEvent) {
		Contract c = tripCompletedEvent.getContract();
		int travellers = c.getTravellers().size();
	    System.out.println("Paying for the holiday: " + c.getHoliday().getName() + 
	    		" for " + travellers + " travellers, price:" + travellers*c.getHoliday().getPrice());
	}
}