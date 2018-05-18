package com.tech.stack.controller;

import com.tech.stack.service.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by zhangwei on 2018/5/18.
 */
@Controller
@RequestMapping("animal")
public class AnimalController {
    /**
     * 如果接口有多个实现类，需要指定参数来选择具体实现类
     */
    @Resource(name = "catServiceImpl")
    private AnimalService animalService;

    @ResponseBody
    @RequestMapping("sayHello")
    public String sayHello() {
        return animalService.sayHello();
    }
}
