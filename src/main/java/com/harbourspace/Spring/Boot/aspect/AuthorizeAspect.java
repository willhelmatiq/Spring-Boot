package com.harbourspace.Spring.Boot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Component
@Aspect
public class AuthorizeAspect {

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public Object authorizeGet(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        for (int i = 0; i < methodSignature.getParameterNames().length; i++) {
            if (methodSignature.getParameterNames()[i].equals("headerParam") && proceedingJoinPoint.getArgs()[i].equals("read")) {
                return proceedingJoinPoint.proceed();
            }
        }
        throw new Throwable("Forbidden");
    }

    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object authorizePost(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        for (int i = 0; i < methodSignature.getParameterNames().length; i++) {
            if (methodSignature.getParameterNames()[i].equals("headerParam") && proceedingJoinPoint.getArgs()[i].equals("write")) {
                return proceedingJoinPoint.proceed();
            }
        }
        throw new Throwable("Forbidden");
    }
}
