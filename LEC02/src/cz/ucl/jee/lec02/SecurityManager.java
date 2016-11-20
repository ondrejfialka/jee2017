package cz.ucl.jee.lec02;


public interface SecurityManager {
	
	boolean checkCredentials(String username, String password);
	
	boolean isRegistrationEnabled();

}
