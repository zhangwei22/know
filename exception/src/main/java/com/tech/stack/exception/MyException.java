package com.tech.stack.exception;

/**
 * Created by zhangwei on 2018/5/21.
 */
public class MyException extends Exception {
    private static final long serialVersionUID = -5519743897907627214L;

    public MyException(String message) {
        super(message);
    }
}
