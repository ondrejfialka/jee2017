package cz.ucl.another;

import java.time.LocalDate;

public interface StockExchangeConnector {

	String getData(long id, LocalDate when);
}
