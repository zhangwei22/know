package com.tech.stack.proxy.cglibproxy;

import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by zhangwei on 2019/9/26.
 *
 * @desc 代理模式：cglib代理
 */
public class Main {

    /**
     * 测试方法
     */
    @Test
    public void cglibProxyTest() {
        // 代理class文件存入本地磁盘，方便反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/zhangwei/Desktop/proxy");

        // 通过CGLib代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        //设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);
        //设置enhancer的回调对象
        enhancer.setCallback(new MyMethodIntercept());
        //创建代理对象
        HelloService proxy = (HelloService) enhancer.create();
        proxy.sayHelo();
    }

}
