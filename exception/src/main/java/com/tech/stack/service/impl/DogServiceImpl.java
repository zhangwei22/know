package com.tech.stack.service.impl;

import com.tech.stack.service.AnimalService;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 2018/5/21.
 */
@Service
public class DogServiceImpl implements AnimalService {
    Byte[] a = new Byte[1024 * 1024];
    Byte[] b = new Byte[1024 * 1024];
    Byte[] c = new Byte[1024 * 1024];

    @Override
    public String sayHello() {
        String name = new String("Jack");
        return "狗叫了一声...";
    }
}
