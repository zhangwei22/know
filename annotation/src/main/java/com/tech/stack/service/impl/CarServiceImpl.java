package com.tech.stack.service.impl;

import com.tech.stack.service.TrafficService;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 2018/5/24.
 */
@Service
public class CarServiceImpl implements TrafficService {
    /**
     * 为了测试@Autowired和new的区别，在这里模拟一个初始化过程
     */
    Byte[] a = new Byte[1024 * 1024];
    Byte[] b = new Byte[1024 * 1024];
    Byte[] c = new Byte[1024 * 1024];

    @Override
    public String run() {
        return "Go Go Go...";
    }
}
