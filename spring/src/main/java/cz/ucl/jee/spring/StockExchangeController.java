package cz.ucl.jee.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.ucl.another.StockExchangeService;

@RestController
public class StockExchangeController {
	
	@Autowired
	StockExchangeService stockExchangeData;

	@RequestMapping(value = "/stocks", method = RequestMethod.GET)
	public String getQuote(@RequestParam String company){
		//hello		
		return stockExchangeData.getQuote(company);
	}
	
	
}
