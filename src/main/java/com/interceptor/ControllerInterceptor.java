package com.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class ControllerInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Object target = invocation.getThis();
        String simpleName = target.getClass().getSimpleName();
        String name = method.getName();
        System.out.println("*** Interceptor class name = " + name);
        System.out.println("*** Interceptor class simpleName = " + simpleName);
        return invocation.proceed();
    }

}
