package cz.ucl.fa.event;

import cz.ucl.fa.model.Contract;

public class TripPurchaseCompleted {
	  private Contract contract;
	 
	  public TripPurchaseCompleted(Contract c) { this.contract = c; }
	 
	  public Contract getContract() { return this.contract; }
	}
