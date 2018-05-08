package com.tech.stack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangwei on 2018/5/8.
 */
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @RequestMapping("gotoIndex")
    public String gotoIndex() {
        return "index";
    }
}
