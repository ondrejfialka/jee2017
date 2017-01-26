package cz.ucl.jee.spring;

import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.ucl.jee.spring.weather.WeatherService;

@RestController
public class WeatherController {
	
	@Autowired(required=false)
	@Qualifier("myWeatherService")
	WeatherService weatherService;

	@RequestMapping(value = "/weather/temperature", method = RequestMethod.GET)
	public String getCurrentTemperature(@RequestParam String location){
		float temperature = weatherService.getCurrentTemperature(location);
		
		return NumberFormat.getInstance().format(temperature);
	}
	
	
}
