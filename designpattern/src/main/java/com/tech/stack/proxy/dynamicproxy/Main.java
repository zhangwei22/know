package com.tech.stack.proxy.dynamicproxy;

import org.junit.Test;

/**
 * Created by zhangwei on 2019/9/26.
 *
 * @desc 代理模式：动态代理
 */
public class Main {

    /**
     * 测试方法
     */
    @Test
    public void dynamicProxyTest() {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        System.out.println(userDaoImpl.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(userDaoImpl).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
