package com.tech.stack.service.impl;

import com.tech.stack.service.AnimalService;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 2018/5/18.
 */
@Service
public class CatServiceImpl implements AnimalService {
    @Override
    public String sayHello() {
        return "Hello, I'm catService!";
    }
}
