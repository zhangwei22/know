package com.tech.stack.service;

import com.tech.stack.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 2018/5/9.
 */
@Service
public class UserService {

//    @Autowired
//    private UserDao userDao;

    public User getUser() {
        User user = new User();
        user.setId(123L);
        user.setName("zhangwei");
        user.setAge(26);
        user.setSex("男");
        //        return userDao.getUser();
        return user;
    }
}
