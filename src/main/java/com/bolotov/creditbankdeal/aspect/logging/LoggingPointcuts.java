package com.bolotov.creditbankdeal.aspect.logging;

import org.aspectj.lang.annotation.Pointcut;

public class LoggingPointcuts {

    @Pointcut("execution(public * com.bolotov.creditbankdeal.service.*.*(..))")
    public void serviceLog() {}

    @Pointcut("execution(public * com.bolotov.creditbankdeal.controller.*.*(..))")
    public void controllerLog() {}

    @Pointcut("execution(public * com.bolotov.creditbankdeal.client.*.*(..))")
    public void clientLog() {}

    @Pointcut("controllerLog() || clientLog()")
    public void restLog() {}

}
