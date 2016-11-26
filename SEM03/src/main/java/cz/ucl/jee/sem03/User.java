package cz.ucl.jee.sem03;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("user")
@SessionScoped
public class User implements Serializable {

	private String username;
	private String password;
	private boolean loggedIn;
	
	public User() {
		super();
		loggedIn = false;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return ""; 			// není vhodné prozrazovat
	} 

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String login() {
		if ("admin".equals(username) && "secret".equals(password)) {
			loggedIn = true;
			return "loginSuccess";
		} else
			return "loginFailure";
	}
	
	public String logout() {
		loggedIn = false;
		return "logoutSuccess";
	}			

}