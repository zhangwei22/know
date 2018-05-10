package com.tech.stack.controller;

import com.tech.stack.entity.User;
import com.tech.stack.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by zhangwei on 2018/5/10.
 */
@Controller
@RequestMapping("transactional")
public class TransactionalController {

    @Autowired
    private TransactionalService transactionalService;

    @ResponseBody
    @RequestMapping("getUser")
    public User getUser() {
        return transactionalService.getUser();
    }

    /**
     * 测试mysql的事务
     */
    @ResponseBody
    @RequestMapping("testTransactional")
    public Object testTransactional() {
        Map<String, Object> result = transactionalService.testTransactional();
        return result;
    }

    /**
     * 测试事务的内部调用（公有方法、私有方法）
     * 测试结果发现，调用内部的事务方法，事务不起作用
     */
    @ResponseBody
    @RequestMapping("testInnerTransactional")
    public Object testInnerTransactional() {
        //测试调用内部公有事务方法
        //        Map<String, Object> result = transactionalService.testPublicInnerInvoke();
        //测试调用内部私有事务方法
        Map<String, Object> result = transactionalService.testPrivateInnerInvoke();
        return result;
    }

    /**
     * 测试事务方法嵌套
     */
    @ResponseBody
    @RequestMapping("testNestTransactional")
    public Object testNestTransactional() {
        Map<String, Object> result = transactionalService.testNestTransactional();
        return result;
    }
}
