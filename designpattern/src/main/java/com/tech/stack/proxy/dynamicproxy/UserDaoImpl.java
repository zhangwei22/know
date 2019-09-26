package com.tech.stack.proxy.dynamicproxy;

/**
 * Created by zhangwei on 2019/9/26.
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据……");
    }
}
