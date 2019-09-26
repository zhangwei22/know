package com.tech.stack.proxy.cglibproxy;

/**
 * Created by zhangwei on 2019/9/26.
 */
public class HelloService {
    public HelloService() {
        System.out.println("HelloService无参构造方法");
    }

    /**
     * 该方法不能被子类覆盖，CGLib无法代理final修饰的方法
     */
    final public String sayOthers(String str) {
        System.out.println("sayOthers:" + str);
        return null;
    }

    public void sayHelo() {
        System.out.println("HelloService:hello cglib proxy!");
    }
}


