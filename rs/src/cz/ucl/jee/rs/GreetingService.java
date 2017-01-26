package cz.ucl.jee.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class GreetingService {

	@GET
	@Path("/greet")
	@Produces(MediaType.TEXT_PLAIN)
	public String greet() {
		return "Hello!";
	}
	
	@GET
	@Path("/greet/long")
	@Produces("application/json")
	public Greeting greetLong() {
		Greeting greeting = new Greeting();
		greeting.setGreeting("Hello");
		greeting.setName("World");
		return greeting;
	}
	
	
	
}
