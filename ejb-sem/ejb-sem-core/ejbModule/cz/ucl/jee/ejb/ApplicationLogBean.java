package cz.ucl.jee.ejb;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.ucl.jee.model.ApplicationLogEntry;

@Remote(ApplicationLog.class)
@Stateless
public class ApplicationLogBean implements ApplicationLog {
	@Resource
	private SessionContext context;
	
	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void logAccess(String action, String object) {
		String principalName = "uzivatel X";//context.getCallerPrincipal().getName();
		ApplicationLogEntry entry = new ApplicationLogEntry(action,object,new Date(),principalName);
		em.persist(entry);
	}
}
