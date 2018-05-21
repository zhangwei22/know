package com.tech.stack.annotation;

import java.lang.annotation.*;

/**
 * Created by zhangwei on 2018/5/21.
 * 自定义一个注解MyLog
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    String value();
}
