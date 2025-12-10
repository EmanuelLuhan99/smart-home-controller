package com.endava.emanuel_luhan.smart_home_controller.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class ControllerLoggingAspect {

    @Before("execution(public * com.endava.emanuel_luhan.smart_home_controller.controller..*(..))")
    public void logControllerCall(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        log.info("Controller call: {} with args = {}", methodName, args);
    }

    @AfterReturning(pointcut = "execution(public * com.endava.emanuel_luhan.smart_home_controller.controller..*(..))",
            returning = "result")
    public void logControllerReturn(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().toShortString();
        log.info("Controller return: {} result={}", methodName, result);
    }
}
