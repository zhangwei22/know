package com.tech.stack.controller;

import com.tech.stack.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangwei on 2018/5/31.
 */
@Controller
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping("setKv")
    public String setKv(String key, String value) throws Exception {
        stringRedisTemplate.opsForValue().set(key, value);
        System.out.println("set begain...");
        StringBuffer sb = new StringBuffer("设置成功:key=");
        sb.append(key);
        sb.append(",value=");
        sb.append(stringRedisTemplate.opsForValue().get(key));
        System.out.println(sb);
        return sb.toString();
    }

    @ResponseBody
    @RequestMapping("getVal")
    public String getVal(String key) throws Exception {
        String val = stringRedisTemplate.opsForValue().get(key);
        StringBuffer sb = new StringBuffer("获取值成功:key=");
        sb.append(key);
        sb.append(",value=");
        sb.append(val);
        System.out.println(sb);
        return sb.toString();
    }

    @RequestMapping("testObj")
    public void testObj() throws Exception {
        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }
}
