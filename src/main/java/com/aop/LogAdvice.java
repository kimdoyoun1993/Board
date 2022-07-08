package com.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Log4j2
@Component
public class LogAdvice {

    @Before("execution(* com.service.ReplyService*.*(..))")  //포인트컷 문법 (문자열로 만들다보니 에러가 정말 많이 난다)
    public void printLog(JoinPoint joinPoint){


        Object[] params = joinPoint.getArgs();
        log.info("------------------");
        log.info("------------------");
        log.info(Arrays.toString(params));
        log.info("------------------");
        log.info("------------------");
    }
}
