package cz.ucl.lec06.ejb;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class ZooBean implements Zoo {
	
	@Resource 
	private TimerService timerService;
	
	private static final Double TICKET_PRICE = 120.0;
	
	@EJB
	private CreditCardPaymentProcessor processor;

	public String getOpeningHours(Date day) {
		return "9:00 – 18:00"; // každý den otevřeno stejně
	}

	public String buyTicket(Date day, String customerName,
			String creditCardNumber, String creditCardValidity)
			throws PaymentFailedException {
		try {
			String paymentId = processor.processPayment(TICKET_PRICE,
					customerName, creditCardNumber, creditCardValidity);
				
			String ticketCode = "TCKT" + paymentId + "_" + day.getTime();
			//Ulož vstupenku do databáze
			//Naplánuj smazání vstupenky skončení po platnosti
			//long interval = day.getTime() + 1*(24*60*60*1000);		//1 den po platnosti
			long interval = (new Date().getTime()) + 30*1000;		//30 vteřin od teď
			timerService.createTimer(new Date(interval), ticketCode);
			
			return ticketCode;
		} catch (PaymentFailedException e) {
			System.out.println("Chyba při platbě vstupenky");
			throw e;
		}
	}
	
	@Timeout
	public void invalidateTicket(Timer timer) {
		String ticketCode = (String) timer.getInfo();
		System.out.println("Vstupenka " + ticketCode + " je nyní neplatná.");
	}
}
