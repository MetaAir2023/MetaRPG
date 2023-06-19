package com.ohgiraffers.metaRPG.domain.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Aspect
@Component
public class UpgradeDomainLoggingAspect {

    public UpgradeDomainLoggingAspect() {

    }
    @Pointcut("execution(* com.ohgiraffers.metaRPG.domain.service.UpgradeDomainService.*(..))")
    public void logPointCut(){}

    @Before("UpgradeDomainLoggingAspect.logPointCut()") //Advice
    public void logBefore(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        if(params.length > 0) {
            for (Object param: params) {
                String log =joinPoint.getSignature() +"'s parameters " + param;
                writeFile(log);
            }
        }
    }

    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        //result = return 받는 어떤 객체
        String log = joinPoint.getSignature() + "'s result : "+ result;
        writeFile(log);
    }

    @AfterThrowing(value = "logPointCut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        String log = "exception message : " + exception.getMessage();
        writeFile(log);
    }

    private void writeFile(String str){
        File file = new File("src/main/resources/metaRPG/logs/log.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.append(str+ '\n');
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //log4j-v2 abs slf4j
}
