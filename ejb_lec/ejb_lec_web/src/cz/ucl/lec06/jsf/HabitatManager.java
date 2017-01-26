package cz.ucl.lec06.jsf;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import cz.ucl.lec06.ejb.PredatorHabitat;


@ManagedBean(name="habitatManager")
@ViewScoped
public class HabitatManager implements Serializable{
	@EJB
	private PredatorHabitat habitat;
	private String selectedHabitat;	

	public String getSelectedHabitat() {
		return selectedHabitat;
	}

	public void setSelectedHabitat(String selectedHabitat) {
		this.selectedHabitat = selectedHabitat;
	}

	public void selectHabitat() {
		try	{
			habitat.openHabitat(selectedHabitat);
		} catch (Exception e){
			selectedHabitat = null;
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Unauthorized acess!", e.getMessage()));		
		}	
	}

	public PredatorHabitat getHabitat() {
		return habitat;
	}
	
	public String closeHabitat() {
		habitat.closeHabitat();
		return "habitat_closed";
	}
		
}
	