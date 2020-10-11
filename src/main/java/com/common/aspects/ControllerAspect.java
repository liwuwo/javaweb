package com.common.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspect {

    @Before(value = "aspect()")
    public void printLog(JoinPoint jp){
        Class clazz = jp.getTarget().getClass();
        System.out.println("*** before getAspect class = " + clazz.getSimpleName() + " ***");
    }


    @Pointcut("execution(* *Service.*(..))")
    public void aspect(){}
}
