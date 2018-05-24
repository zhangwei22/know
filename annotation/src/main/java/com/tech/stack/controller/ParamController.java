package com.tech.stack.controller;

import com.tech.stack.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangwei on 2018/5/24.
 */
@Controller
@RequestMapping("param")
public class ParamController {

    @RequestMapping("gotoIndex")
    public String gotoIndex() {
        return "index";
    }

    /**
     * 默认http请求参数不加@RequestBody注解
     *
     * @param request
     * @param person
     * @return json
     */
    @ResponseBody
    @RequestMapping("defaultRequest")
    public Map<String, Object> defaultRequest(HttpServletRequest request, Person person) {
        Map<String, Object> result = new HashMap(10);
        result.put("name1", person.getName());
        result.put("age1", person.getAge());
        result.put("sex1", person.getSex());
        result.put("idCard1", person.getIdCard());
        String contentType = request.getContentType();
        System.out.println("ct1:" + contentType);
        return result;
    }

    /**
     * 参数加@RequestBody注解
     */
    @ResponseBody
    @RequestMapping("RequestBody")
    public Map<String, Object> RequestBody(HttpServletRequest request, @RequestBody Person person) {
        Map<String, Object> result = new HashMap(10);
        result.put("name2", person.getName());
        result.put("age2", person.getAge());
        result.put("sex2", person.getSex());
        result.put("idCard2", person.getIdCard());
        String contentType = request.getContentType();
        System.out.println("ct2:" + contentType);
        return result;
    }

}
