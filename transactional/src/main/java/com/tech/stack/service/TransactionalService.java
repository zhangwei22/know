package com.tech.stack.service;

import com.tech.stack.entity.User;
import com.tech.stack.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangwei on 2018/5/10.
 */
@Service
public class TransactionalService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 简单的查询语句
     */
    public User getUser() {
        return userMapper.findUser();
    }

    /**
     * 测试事务
     * 在springboot中，不需要任何额外配置就可以用@Transactional注解进行事务的使用
     */
    @Transactional
    public Map<String, Object> testTransactional() {
        Map<String, Object> paramMap = new HashMap<>();
        User user = userMapper.findUser();
        System.out.println("findUser:" + user);
        User user1 = new User("wangmazz", 19, "男");
        System.out.println("insertUser:" + user1);
        userMapper.saveUser(user1);
        //这里制造一个异常（数据库sex字段只有4位），这里报异常后数据回滚到事务执行之前
        User user2 = new User("caiwenji", 16,
                "女45078-458590325783590-46953429683459625=40-684539=78345607");
        userMapper.saveUser(user2);
        User user3 = new User("zhugeliang", 16, "w");
        userMapper.saveUser(user3);
        paramMap.put("user", user);
        return paramMap;
    }

    /**
     * 定义一个私有的事务方法用于内部调用
     */
    @Transactional
    private Map<String, Object> testPrivate() {
        Map<String, Object> paramMap = new HashMap<>();
        User user = userMapper.findUser();
        System.out.println("findUser:" + user);
        User user1 = new User("liergou", 19, "男");
        //这里制造一个异常（数据库sex字段只有4位），这里报异常后数据回滚到事务执行之前
        User user2 = new User("liubei", 16,
                "男45078-458590325783590-469534-29683459625=40-684539=78345607");
        User user3 = new User("zhangliangyin", 16, "man");
        System.out.println("insertUser:" + user1);
        userMapper.saveUser(user1);
        userMapper.saveUser(user2);
        userMapper.saveUser(user3);
        paramMap.put("user", user);
        return paramMap;
    }

    /**
     * 测试调用内部的public事务方法
     * 测试结果证明，调用内部的事务方法，事务不起作用
     */
    public Map<String, Object> testPublicInnerInvoke() {
        return testTransactional();
    }

    /**
     * 测试调用内部的private事务方法
     * 测试结果证明，调用内部的事务方法，事务也不起作用
     */
    public Map<String, Object> testPrivateInnerInvoke() {
        return testPrivate();
    }

    /**
     * 测试嵌套的事务
     * 方法B有异常。方法A调用B事务之前异常：事务生效，数据回滚到事务执行之前
     * 方法B有异常。方法A调用B事务之后异常：事务生效，数据回滚到事务执行之前
     * 方法B有异常。方法A不发生异常：事务生效，数据回滚到事务执行之前
     * 方法A,B都没有异常：事务生效，数据正常执行
     * 方法B没异常，方法A调用B事务之后异常: 事务生效，数据回滚到事务执行之前
     */
    @Transactional
    public Map<String, Object> testNestTransactional() {
        Map<String, Object> paramMap = new HashMap<>();
        User user = userMapper.findUser();
        System.out.println("findUser-A:" + user);
        User user1 = new User("liuluoguo", 19, "男");
        System.out.println("insertUser:" + user1);
        userMapper.saveUser(user1);
        //调用B事务之前异常
        //        User user2 = new User("zhangfei", 12, "女45078-45325783590-469534-29683459625=40-684535607");
        //        userMapper.saveUser(user2);

        //调用B事务
        testTransactional();

        //调用B事务之后异常
        User user3 = new User("zhaozilong", 16,
                "男45078-45325783590-469534-29683459625=40-684535607");
        userMapper.saveUser(user3);
        User user4 = new User("zhangliao", 18, "m");
        userMapper.saveUser(user4);
        paramMap.put("user", user);
        return paramMap;
    }

    /**
     * 方法A和方法B出现不同的异常又会出现什么
     * */

    /**
     * 方法A和方法B不同的事务隔离级别又会出现什么
     * */

    /**
     * 什么是分布式事务
     * */

}
