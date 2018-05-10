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
        //这里制造一个异常（数据库sex字段只有4位），这里报异常后数据回滚到事务执行之前
        User user2 = new User("caiwenji", 16,
                "女45078-458590325783590-469534-29683459625=40-684539=78345607");
        User user3 = new User("zhugeliang", 16, "woman");
        System.out.println("insertUser:" + user1);
        userMapper.saveUser(user1);
        userMapper.saveUser(user2);
        userMapper.saveUser(user3);
        paramMap.put("user", user);
        return paramMap;
    }

    @Transactional
    private Map<String, Object> testPrivate() {
        Map<String, Object> paramMap = new HashMap<>();
        User user = userMapper.findUser();
        System.out.println("findUser:" + user);
        User user1 = new User("wangmazz", 19, "男");
        //这里制造一个异常（数据库sex字段只有4位），这里报异常后数据回滚到事务执行之前
        User user2 = new User("caiwenji", 16,
                "女45078-458590325783590-469534-29683459625=40-684539=78345607");
        User user3 = new User("zhugeliang", 16, "woman");
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

}
