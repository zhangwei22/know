package com.tech.stack.controller;

import com.tech.stack.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangwei on 2018/5/5.
 */
@Controller
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private IHelloService iHelloService;

    @ResponseBody
    @RequestMapping("sayHello")
    public String sayHello(){
        String s = iHelloService.sayHello("dubbo练成之路");
        return s;
    }
}
