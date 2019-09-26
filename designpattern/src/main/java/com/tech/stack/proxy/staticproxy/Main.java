package com.tech.stack.proxy.staticproxy;

import org.junit.Test;

/**
 * Created by zhangwei on 2019/9/26.
 *
 * @desc 代理模式：静态代理
 */
public class Main {

    /**
     * 测试方法
     */
    @Test
    public void staticProxyTest() {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        UserDaoProxy proxy = new UserDaoProxy(userDaoImpl);
        proxy.save();
    }
}
