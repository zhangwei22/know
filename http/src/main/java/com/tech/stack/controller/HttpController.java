package com.tech.stack.controller;

import com.tech.stack.util.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangwei on 2018/5/14.
 */
@Controller
@RequestMapping("http")
public class HttpController {

    /**
     * 获取request的cookies
     * 并拼接成"key1=value1;key2=value2;key3=..."的格式
     */
    @ResponseBody
    @RequestMapping("testRequestHeader")
    public String testRequestHeader(HttpServletRequest request) {
        String cookies = HttpClientUtils.getCookies(request);
        return cookies;
    }
}
