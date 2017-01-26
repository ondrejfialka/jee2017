package cz.ucl.another;

import java.time.LocalDate;

public class StockExchangeService {

	private String exchangeName;
		
	private StockExchangeConnector connector;
	
	public String getExchangeName() {
		return exchangeName;
	}
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}
	
	


	public StockExchangeConnector getConnector() {
		return connector;
	}
	public void setConnector(StockExchangeConnector connector) {
		this.connector = connector;
	}
	public String getQuote(String company){	
		long id = 123;
		LocalDate when = LocalDate.now();
		return exchangeName + ": " + company + ": " + connector.getData(id, when);
	}
	
}
