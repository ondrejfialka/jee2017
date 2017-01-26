package cz.ucl.jee.spring.weather;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myWeatherService")
@Scope("singleton")
public class MockWeatherService implements WeatherService {

	public float getCurrentTemperature(String location) {
		
		return 17.5f;
	}

	
}
