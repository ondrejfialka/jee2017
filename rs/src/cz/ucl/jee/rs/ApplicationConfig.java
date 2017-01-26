package cz.ucl.jee.rs;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {

	//Defines the components of a JAX-RS application and supplies additional meta-data. 
	//A JAX-RS application or implementation supplies a concrete subclass of this abstract class.
	/*@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();
		resources.add(GreetingService.class);
		return resources;
		
	}*/

}
