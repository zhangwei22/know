package com.tech.stack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangwei on 2018/5/14.
 */
@Controller
@RequestMapping("http")
public class HttpController {
    public static final String username = "jack888";

    /**
     * 获取request的cookies
     * 并拼接成"key1=value1;key2=value2;key3=..."的格式
     */
    @ResponseBody
    @RequestMapping(value = "testRequestHeader", method = RequestMethod.POST)
    public List<Student> testRequestHeader(HttpServletRequest request, String name, int sex) {
        //        String cookies = HttpClientUtils.getCookies(request);
        //        return cookies;
        Student s = new Student();
        s.setId("123");
        s.setStdId("xue555");
        s.setStdName("晚饭是");
        List<Student> list = new ArrayList<>();
        list.add(s);
        list.add(s);
        list.add(s);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangwei");
        map.put("sex", 24);
        map.put("stuList", list);
        map.put("jackname", HttpController.username);
        //        map.put("student", s);
        return list;
    }
}
