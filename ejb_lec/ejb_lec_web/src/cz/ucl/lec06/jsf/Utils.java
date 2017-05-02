package cz.ucl.lec06.jsf;


import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named("utils")
@ApplicationScoped
public class Utils {
	// this method simply invalidates the current session
	  public String logout() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
	    session.invalidate();
	    return "logged_out";
	  }
	  
	  public boolean getLoggedIn() {
		  return (null != FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal());
	  }
	  
	  public String getPrincipalName() {
		  return FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
	  }
	  
}
