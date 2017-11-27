package cz.ucl.another.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.ucl.another.StockExchangeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-example-servlet.xml")
public class StockExchangeTest {

	@Autowired
	StockExchangeService stockExchangeService;
	
	@Test
	public void testStockExchange() {
		assertNotNull(stockExchangeService.getConnector());
	}
	
}
