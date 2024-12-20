package com.bolotov.creditbankdeal.aspect.logging;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class ControllerLoggingAspect {

    @Before("LoggingPointcuts.controllerLog()")
    public void doBeforeController(JoinPoint jp) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (attributes != null) {
            request = attributes.getRequest();
        }
        if (request != null) {
            log.info("NEW REQUEST: IP: {}, URL: {}, HTTP_METHOD: {}, CONTROLLER_METHOD: {}.{}",
                    request.getRemoteAddr(),
                    request.getRequestURL().toString(),
                    request.getMethod(),
                    jp.getSignature().getDeclaringTypeName(),
                    jp.getSignature().getName());
        }
    }

    @AfterReturning(returning = "returnObject", pointcut = "LoggingPointcuts.controllerLog()")
    public void doAfterReturningController(Object returnObject) {
        log.info("Return value: {}", returnObject);
    }

    @After("LoggingPointcuts.controllerLog()")
    public void doAfter(JoinPoint jp) {
        log.info("Controller Method executed successfully: {}.{}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName());
    }

    @AfterThrowing(throwing = "ex", pointcut = "LoggingPointcuts.controllerLog()")
    public void throwsException(JoinPoint jp, Exception ex) {
        String methodName = jp.getSignature().getName();
        String className = jp.getTarget().getClass().getSimpleName();

        log.error("Exception in {}.{} with arguments {}. Exception message: {}",
                className, methodName, Arrays.toString(jp.getArgs()), ex.getMessage());
    }
}
