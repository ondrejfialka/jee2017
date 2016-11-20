package cz.ucl.jee.lec02;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class User implements Serializable {
	private String username;
	private String password;
	private boolean loggedIn;
	private boolean registrationEnabled;
	
	@Inject 
	private SecurityManager securityManager;
	
	
	private Conversation conversation;
	
	@PostConstruct
	public void initialize() {
		//post construct is called after all dependencies are injected
		registrationEnabled = securityManager.isRegistrationEnabled();		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return ""; 	// není vhodné prozrazovat
	} 

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public boolean isRegistrationEnabled(){
		return registrationEnabled;
	}
	
	public String login() {
		if (securityManager.checkCredentials(username, password)) {
			loggedIn = true;
			return "success";
		} else
			return "failure";
	}
	
	public String getVersion(){
		return FacesContext.class.getPackage().getImplementationVersion();
	}
}