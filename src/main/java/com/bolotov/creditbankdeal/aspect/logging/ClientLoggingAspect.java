package com.bolotov.creditbankdeal.aspect.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class ClientLoggingAspect {

    @Before("LoggingPointcuts.clientLog()")
    public void logBeforeClient(JoinPoint jp) {
        log.info("RUN CLIENT: CLIENT_METHOD: {}.{} CLIENT_ARGUMENTS: [{}]",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                Arrays.toString(jp.getArgs()));
    }
}
