package cz.ucl.cdi.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import cz.ucl.cdi.annotation.Monitored;

@Interceptor
@Monitored
public class MonitoringInterceptor implements Serializable {
    
    @AroundInvoke
    public Object timeExecution(InvocationContext invocation) throws Exception {
        long oldTime = System.currentTimeMillis();
        
        Object result = invocation.proceed();
        
        long duration = System.currentTimeMillis() - oldTime;
        System.out.println("!MONITOR!: Duration of " + invocation.getTarget().getClass().getSimpleName() + 
                 "." + invocation.getMethod().getName() + " took " + duration + " milliseconds.");
        
        return result;
    }
}
