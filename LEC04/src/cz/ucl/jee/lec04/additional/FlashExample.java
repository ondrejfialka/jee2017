package cz.ucl.jee.lec04.additional;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.Flash;

@ManagedBean
@RequestScoped
public class FlashExample implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{flash}")
	private Flash flash;
	
	public String getInputFromFlash(){
		//FacesContext.getCurrentInstance().getExternalContext().getFlash()
		String inputText  = (String) flash.get("inputText");
		
		//flash.keep("inputText");
		return inputText;
	}

	public void setFlash(Flash flash) {
		this.flash = flash;
	}

	public Flash getFlash() {
		return flash;
	}
	
}