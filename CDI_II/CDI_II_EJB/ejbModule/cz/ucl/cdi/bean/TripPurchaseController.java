package cz.ucl.cdi.bean;


import cz.ucl.fa.model.Contract;
import cz.ucl.fa.model.Holiday;
import cz.ucl.fa.model.Traveller;

public interface TripPurchaseController{

	public String createContract(Long holidayId);
	public String saveContract();
	public String addTraveller();
	
	public abstract Traveller getTraveller();
	public abstract Contract getContract();
	public abstract Holiday getHoliday();
}
