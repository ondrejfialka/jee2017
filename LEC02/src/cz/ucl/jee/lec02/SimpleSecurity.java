package cz.ucl.jee.lec02;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SimpleSecurity implements SecurityManager {

	@Override
	public boolean checkCredentials(String username, String password){
		return ("admin".equals(username) && "secret".equals(password));
	}

	@Override
	public boolean isRegistrationEnabled() {		
		return true;
	}
}
