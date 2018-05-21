package com.tech.stack.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by zhangwei on 2018/5/21.
 * 解析注解MyLog
 */
@Aspect     //AOP切面
@Component
public class MyLogAspect {

    @Pointcut("@annotation(com.tech.stack.annotation.MyLog)")
    public void annotationPointCut() {

    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        MyLog myLog = method.getAnnotation(MyLog.class);
        System.out.println("打印：" + myLog.value() + "前置日志");
    }
}
