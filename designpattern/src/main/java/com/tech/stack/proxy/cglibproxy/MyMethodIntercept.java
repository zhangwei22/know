package com.tech.stack.proxy.cglibproxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhangwei on 2019/9/26.
 */
public class MyMethodIntercept implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("事务开始");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("事务结束");
        return object;
    }
}
