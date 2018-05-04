package com.tech.stack.service;

import com.tech.stack.entity.Person;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 2018/5/4.
 *
 * 模拟业务层操作
 */
@Service
public class PersonService {

    public Person getPersonById(Long id) {
        Person person = new Person();
        person.setId(id);
        person.setName("乔丹");
        person.setAge(23);
        //模拟后端的处理时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return person;
    }
}
