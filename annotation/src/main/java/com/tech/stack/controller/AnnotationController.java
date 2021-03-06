package com.tech.stack.controller;

import com.tech.stack.annotation.MyLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangwei on 2018/5/21.
 * <p>
 * 测试自定义注解@MyLog
 * http://127.0.0.1:8080/annotation/index
 * </p>
 */
@RestController
@RequestMapping("annotation")
public class AnnotationController {

    @MyLog("测试/annotation/index")
    @RequestMapping("index")
    public String index() {
        System.out.println("进入index方法!");
        return "request index success!";
    }
}
