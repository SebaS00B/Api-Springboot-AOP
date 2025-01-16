package com.sebas.springboot.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicesPointCuts {
    @Pointcut("execution(* com.sebas.springboot.aop.springboot_aop..*.*(..))")
    public void greetingLoogerPointCut() {}

    @Pointcut("execution(* com.sebas.springboot.aop.springboot_aop..*.*(..))")
    public void greetingFooLoogerPointCut() {}
}
