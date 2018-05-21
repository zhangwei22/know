package com.tech.stack.exception;

/**
 * Created by zhangwei on 2018/5/21.
 */
public class MyRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -6925278824391495117L;

    public MyRuntimeException(String message) {
        super(message);
    }
}
