package cz.ucl.jee.ejb;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ApplicationLogInterceptor {
	@EJB
	private ApplicationLog log;
	
	@AroundInvoke
	public Object logAccess(InvocationContext invocation) throws Exception{		
		log.logAccess(invocation.getMethod().toString(), invocation.getTarget().getClass().getName());
		return invocation.proceed();
	}
}
