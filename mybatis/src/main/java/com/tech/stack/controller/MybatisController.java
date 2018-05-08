package com.tech.stack.controller;

import com.tech.stack.entity.User;
import com.tech.stack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangwei on 2018/5/8.
 */
@Controller
@RequestMapping("mybatis")
public class MybatisController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("findUser")
    public User findUser() {
        User user = userService.findUser();
        System.out.println(user);
        return user;
    }
}
