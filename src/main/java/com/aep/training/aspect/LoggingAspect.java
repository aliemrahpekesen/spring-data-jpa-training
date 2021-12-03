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
            "within(@org.springframework.web.bind.annotation.RestController *)"
    )
    public void myControllers(){}

    @Before(
            "myControllers()"
    )
    public void herMethoddanOnce(JoinPoint joinPoint){
            logger.info("Methoddan Önce Çalışan Yer!");
            logger.info("Çalışacak Method Adı : "+joinPoint.getSignature().getName());
    }

    @After(
            "myControllers()"
    )
    public void herMethoddanSonra(JoinPoint joinPoint){
        logger.info("Bitirilen Method Adı : "+joinPoint.getSignature().getName());
        logger.info("Methoddan Sonra Çalışan Yer!");
    }

    @Around(
            "myControllers()"
    )
    public Object herMethodExecutioninda(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("GİRİŞ --> | {}.{}() Çağırılıyor. Argünalarıda : ({})",
                proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName(),
                Arrays.toString(proceedingJoinPoint.getArgs()));

        Object result =null;
        try {
            result = proceedingJoinPoint.proceed();

            logger.info("ÇIKIŞ --> | {}.{}() Çıkılıyor. Sonuç : ({})",
                    proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                    proceedingJoinPoint.getSignature().getName(),
                    result.toString());

            return result;
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return result;
    }
}
