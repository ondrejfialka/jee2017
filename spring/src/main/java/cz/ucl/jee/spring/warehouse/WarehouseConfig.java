package cz.ucl.jee.spring.warehouse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WarehouseConfig {
	
	@Bean(name="warehouse")
	public WarehouseDao warehouseDao(){
		
		WarehouseDao dao =  new WarehouseDaoImpl();
			
		//if you need to reference another bean, just call the method
		WarehouseHelper helper = warehouseHelper();
		
		return dao;
	}
	
	
	@Bean
	public WarehouseHelper warehouseHelper(){
		
		return new WarehouseHelper();
	}
	

}
