package cz.ucl.lec06.ejb;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Remove;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

@Stateful
@PermitAll
public class PredatorHabitatBean implements PredatorHabitat {
	@Resource
	private SessionContext ctx;
	
	private String activeHabitat;
	
	private String openedByUser;
	
	private Double temperature;
	private Double meat;
	private Double salad;

	@RolesAllowed({"PredatorFriend"})
	public void openHabitat(String habitat) {
		this.activeHabitat = habitat;
		this.openedByUser = ctx.getCallerPrincipal().getName();
	}
	
	@Override
	public void feed(Double meatWeight, Double saladWeight) {
		meat += meatWeight;
		salad += saladWeight;
	}

	@Override	
	@RolesAllowed({"PredatorFriend"})
	public void setTemperature(Double newTemperature) {
		temperature = newTemperature;
		System.out.println("New temperature for " + activeHabitat + ": " + newTemperature);
	}	

	@Override
	public Double getTemperature() {
		return temperature;
	}

	@Remove
	public void closeHabitat() {
		if (ctx.getCallerPrincipal().getName().equals(openedByUser))
			this.activeHabitat = null;
		else throw new RuntimeException("Habitat opened by user " + openedByUser);
	}	
}