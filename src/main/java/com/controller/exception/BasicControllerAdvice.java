package com.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class BasicControllerAdvice {
    //잘못된 것 을 위한 <예외 처리>
    //대표적으로 목록 페이지 가는데 페이지 번호를 문자열로 주면 안 되는데 그럴 경우

    @ResponseBody //return 을 객체로 받는
    @ExceptionHandler(Exception.class)
    public String exceptCommon(Exception exception) {

        log.error("-----------------------------------");
        log.error(exception.getMessage());

        StringBuffer buffer = new StringBuffer("<ul>");

        buffer.append("<li>" + exception.getMessage() + "</li>");

        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>" + stackTraceElement + "</li>");
        });
        buffer.append("</ul>");

        return buffer.toString();
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){

        return "custom404";
    }
}