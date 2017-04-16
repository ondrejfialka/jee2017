package cz.ucl.cdi.bean;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cz.ucl.fa.model.Contract;
import cz.ucl.fa.model.Holiday;
import cz.ucl.fa.model.Traveller;
import cz.ucl.fa.model.util.TestData;

@ConversationScoped
@Named
public class TripPurchaseControllerBean implements TripPurchaseController, Serializable {
	private Holiday holiday;
	private Contract contract;
	private Traveller traveller;

	@Inject
	private TestData testData;
	
	@Inject
	private Conversation conversation;
					
	@Override
	public String createContract(Long holidayId) {
		System.out.println("Creating a contract");

		holiday = testData.getHolidayById(holidayId);

		contract = new Contract();
		contract.setHoliday(holiday);

		traveller = new Traveller();

		conversation.begin();
		System.out.println("Starting a conversation with cid="
				+ conversation.getId());
		
		return "/view/add_traveller.xhtml";
	}

	@Override
	public String addTraveller() {
		System.out.println("Adding a traveller");
		
		contract.addTraveller(traveller);

		traveller = new Traveller();
		
		return "/view/add_traveller.xhtml";
	}

	@Override
	public String saveContract() {
		System.out.println("Saving the contract with " + contract.getTravellers().size() + " travellers");

		System.out.println("The conversation with cid=" + conversation.getId()
				+ " is ending");
		conversation.end();
		
		return "/index.xhtml";
	}

	@Override
	public Holiday getHoliday() {
		return holiday;
	}

	@Override
	public Contract getContract() {
		return contract;
	}

	@Override
	public Traveller getTraveller() {
		return traveller;
	}	

}
