package com.tech.stack.service;

import com.tech.stack.entity.User;
import com.tech.stack.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 2018/5/8.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUser() {
        return userMapper.findUser();
    }
}
