package com.tech.stack.controller;

import com.tech.stack.entity.Person;
import com.tech.stack.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangwei on 2018/5/7.
 */
@Controller
@RequestMapping("jsp")
public class JspController {
    @Autowired
    private PersonService personService;

    @RequestMapping("getIndex")
    public String getIndex(HttpServletRequest request) {
        Person person = personService.getPerson();
        request.setAttribute("person", person);
        return "index";
    }
}
