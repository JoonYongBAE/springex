package net.ict.springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.lang.reflect.Array;
import java.util.Arrays;

@ControllerAdvice//데이터 값이 잘못 들어오면 다른 것보다 먼저 실행이 되는 어노테이션이다.
@Log4j2
public class CommonExceptionAdvice {


    // *넘버익셉션*
    //응답하는 바디 안에서 파라미터로 받는 값이 숫자인데 숫자가 아닌 다른 값이 들어가서
    // NumberFormatException이 실행되면 아래의 exception을 보여준다.
//    @ResponseBody
//    @ExceptionHandler(NumberFormatException.class)
//    public String exceptNumber(NumberFormatException numberFormatException){
//        log.error("=====================");
//        log.error(numberFormatException.getMessage());
//        return "NUMBER FORMAT EXCEPTION";
//
//    }

    //예외 처리의 최상위 타입인 Exception타입을 처리하도록 구성 exceptCommon(Exception exception)

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exception(Exception exception){
        log.error("=====error==========");
        log.error(exception.getMessage());

        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>"+ exception.getMessage()+"</li>");
        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>"+ stackTraceElement+"</li>");
        });
        buffer.append("</ul>");
        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "custom404";//내가 지정한 String 값과 같은 jsp를 찾는다.
    }


}
