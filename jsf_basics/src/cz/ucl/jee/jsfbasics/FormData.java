package cz.ucl.jee.jsfbasics;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class FormData {

	private Date date;	
	private String username;
	private String password;
	
	@Inject
	UserManager userManager;
	
	public FormData(){
		date = new Date();
	}
	
	public void createUser(){
		userManager.addUser(username, password);
	}
	
	public Date getDate(){
		return date;
	}
			
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}		
}
