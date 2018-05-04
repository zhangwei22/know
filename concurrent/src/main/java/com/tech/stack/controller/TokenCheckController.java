package com.tech.stack.controller;

import com.tech.stack.entity.Person;
import com.tech.stack.service.PersonService;
import com.tech.stack.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangwei on 2018/5/4.
 */
@Controller
@RequestMapping("tokenCheck")
public class TokenCheckController {

    @Autowired
    private PersonService personService;

    /**
     * 用token来解决用户请求重复提交
     * token可以是userId加盐
     */
    @ResponseBody
    @RequestMapping("getPersonData")
    public Person getPersonData(String token, Long id) throws Exception {
        Person person = null;
        if (token == null || id == null) {
            return person;
        }
        String session = RedisUtils.tokenMap.get(token);
        if (session != null) {
            return person;
        }
        RedisUtils.tokenMap.put(token, token);
        System.out.println(Thread.currentThread().getName() + "executor start");
        //模拟后端的处理时间
        person = personService.getPersonById(id);
        System.out.println(Thread.currentThread().getName() + "executor end");
        RedisUtils.tokenMap.remove(token);
        return person;
    }
}
