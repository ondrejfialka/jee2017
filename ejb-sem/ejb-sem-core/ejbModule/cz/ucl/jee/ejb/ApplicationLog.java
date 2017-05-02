package cz.ucl.jee.ejb;


public interface ApplicationLog {
	public void logAccess(String action, String object) ;
}
