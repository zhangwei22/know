package com.tech.stack.proxy.staticproxy;

/**
 * Created by zhangwei on 2019/9/26.
 */
public class UserDaoProxy implements IUserDao {
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("事务开始");
        target.save();
        System.out.println("事务结束");
    }
}
