package cz.ucl.jee.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.ucl.jee.spring.warehouse.WarehouseDao;

@RestController
public class WarehouseController {

	@Autowired
	private WarehouseDao dao;
	
	@RequestMapping(value = "/warehouse", method = RequestMethod.GET)
	public String itemsInStorage(@RequestParam String itemCode){
		return String.valueOf(dao.getNumberOfItems(itemCode));
	}
	
}
