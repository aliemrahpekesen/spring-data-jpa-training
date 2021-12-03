package com.aep.training.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private final static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut(
            "within(@org.springframework.stereotype.Repository *)" +
                    " || within(@org.springframework.stereotype.Service *)" +
                    " || within(@org.springframework.stereotype.Controller *)" +
                    " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springAnnotations(){ }

    @Pointcut(
            "within(com.aep.training.controller.v1.*)" +
                    " || within(com.aep.training.service..*)" +
                    " || within(com.aep.training.repository.*)")
    public void applicationSpecific(){ }

    @AfterThrowing(pointcut = "springAnnotations() && applicationSpecific()",throwing = "e")
    public void logErrors(JoinPoint joinPoint,Throwable e){
        logger.error("Excetion has occured at {}.{}() || Message is ({})",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                e.getMessage()!=null?e.getMessage():"EMPTY");
    }


    @Around("springAnnotations() && applicationSpecific()")
    public Object logAll(ProceedingJoinPoint joinPoint){

        if (logger.isDebugEnabled()) {
            logger.debug("Giriş --> {}.{}() || Gelen Parametreler : {}",
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(),
                    Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = null;
            try {
                result = joinPoint.proceed();
                if (logger.isDebugEnabled()) {
                    logger.debug("Çıkış --> {}.{}() || Sonuç : {}",
                            joinPoint.getSignature().getDeclaringTypeName(),
                            joinPoint.getSignature().getName(),
                            result);
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }

            return result;
        } catch (IllegalArgumentException e){
            logger.error("Illegal Argument Exception Oluştu : "+e.getStackTrace());
            throw  e;
        }
    }

}
