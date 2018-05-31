package com.tech.stack.service.impl;

import com.tech.stack.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 2018/5/5.
 */
@Service("helloServiceImpl")
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String name) {
        return "【生产者】Hello, " + name;
    }
}
