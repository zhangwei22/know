package com.tech.stack.service;

import com.tech.stack.dao.UserDao;
import com.tech.stack.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 2018/5/9.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser() {
        User user = userDao.getUser();
        return user;
    }
}
