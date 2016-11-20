package cz.ucl.jee.jsfbasics;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class UserManager implements Serializable {	
	private int userCount = 0;
	public void addUser(String username, String password) {		
		System.out.println("Adding user " + username);
		userCount++;
	}
	public int getUserCount() {
		return userCount;
	}		
}
