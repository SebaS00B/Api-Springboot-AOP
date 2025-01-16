package com.sebas.springboot.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@Aspect
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(GreetingAspect.class);
    
   

    @Before("GreetingServicesPointCuts.greetingLoogerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes " + method + " con los argumentos " + args);
    }

    @After("GreetingServicesPointCuts.greetingLoogerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues " + method + " con los argumentos " + args);
    }

    @AfterReturning("GreetingServicesPointCuts.greetingLoogerPointCut()")
    public void loggerAfterReturnig(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de retornar " + method + " con los argumentos " + args);
    }

    @AfterThrowing("GreetingServicesPointCuts.greetingLoogerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de lanzar excepcion" + method + " con los argumentos " + args);
    }

    @Around("GreetingServicesPointCuts.greetingLoogerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null ;
        try {
            logger.info("Antes de ejecutar " + method + " con los argumentos " + args);
            result = joinPoint.proceed();
            logger.info("Despues de ejecutar " + method + " retorna el valor " + result);
            return result;
        } catch (Throwable e) {
            
            logger.error("Despues de lanzar excepcion " + method + " con los argumentos " + args);
            throw e;
        }
        }
        
}
