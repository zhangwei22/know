package com.tech.stack.service;

import com.tech.stack.entity.Person;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 2018/5/7.
 */
@Service
public class PersonService {

    public Person getPerson() {
        Person person = new Person();
        person.setName("张三");
        person.setSex("男");
        person.setAge(26);
        person.setJob("码农");
        return person;
    }
}
