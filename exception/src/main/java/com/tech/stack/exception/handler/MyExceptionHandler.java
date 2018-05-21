package com.tech.stack.exception.handler;

import com.tech.stack.exception.MyException;
import com.tech.stack.exception.MyRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangwei on 2018/5/21.
 * <p>
 * 注意：ControllerAdvice只能捕获到全局Controller范围内的异常，之外的异常就无法捕获。如filter中抛出异常的话，
 * ControllerAdvice是无法捕获的。这时候就需要按照官方文档中的方法，实现ErrorController并注册为controller
 */
@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerMyException(MyException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", ex.getMessage());
        result.put("errorType", "MyException");
        return result;
    }

    @ExceptionHandler(MyRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerMyRuntimeException(MyRuntimeException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", ex.getMessage());
        result.put("errorType", "MyRuntimeException");
        return result;
    }
}
