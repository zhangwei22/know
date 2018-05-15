package com.tech.stack.test;

import com.alibaba.fastjson.JSONObject;
import com.tech.stack.util.HttpClientUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangwei on 2018/5/14.
 */
public class MainTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap();
        map.put("cityId", 483);
        try {
            String result = HttpClientUtils.sendPost("", map, "");
            System.out.println("resultStr:" + result);
            JSONObject obj = JSONObject.parseObject(result);
            JSONObject json = JSONObject.parseObject(obj.toString());
            Integer statusCode = json.getInteger("code");
            System.out.println(statusCode);
            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
