package cz.ucl.another;

import java.time.LocalDate;

public class SimpleConnector implements StockExchangeConnector {

	@Override
	public String getData(long id, LocalDate when) {		
		return " 39.28+0.19 (+0.47%)";
	}

}
