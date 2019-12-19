package cdi;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Auditavel
@Priority(Interceptor.Priority.APPLICATION)
public class InterceptadorAuditavel{
    
    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("Antes da Execução");
        Object res = context.proceed();
        System.out.println("Depois da Execução");
        return res;
    } 
}
