package cz.ucl.br.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import cz.ucl.jee.ejb.HotelManager;
import cz.ucl.jee.ejb.ReservationManager;

public class BlueResortsLocator {                 
	public static final String HOTEL_JNDI_LOCATION = "/ejb-sem-ear-1.0-SNAPSHOT/ejb-sem-core/HotelManagerBean!cz.ucl.jee.ejb.HotelManager";
	public static final String RESERVATION_JNDI_LOCATION = "/ejb-sem-ear-1.0-SNAPSHOT/ejb-sem-core/ReservationManagerBean!cz.ucl.jee.ejb.ReservationManager";

	// můžeme uchovávat neomezeně a používat ve více vláknech
	private Context ctx;

	// můžeme uchovávat, protože jde o odkaz na SLSB
	private ReservationManager reservationManagerCache;

	public BlueResortsLocator() {
		
		try {			
			Properties prop = new Properties();
			  
			prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
			//prop.put(Context.SECURITY_PRINCIPAL, "username");
			//prop.put(Context.SECURITY_CREDENTIALS, "password");
			          
			prop.put("jboss.naming.client.ejb.context", true);
			  
			ctx = new InitialContext(prop);	        
		      
		} catch (NamingException e) {
			e.printStackTrace();
			ctx = null;
		}
	}

	public ReservationManager getReservationManager() {
		if (reservationManagerCache == null) {
			try {
				reservationManagerCache = (ReservationManager) ctx
						.lookup(RESERVATION_JNDI_LOCATION);
			} catch (NamingException e) {
				reservationManagerCache = null;
			}
		}
		return reservationManagerCache;
	}

	public HotelManager getHotelManager() {
		try {
			Object o = ctx.lookup(HOTEL_JNDI_LOCATION);
			return (HotelManager) ctx.lookup(HOTEL_JNDI_LOCATION);
		} catch (NamingException e) {
			return null;
		}
	}
	
	/*public UserTransaction getUserTransaction() {
		try {
			return (UserTransaction) ctx.lookup("java:jboss/UserTransaction");
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}*/

}
