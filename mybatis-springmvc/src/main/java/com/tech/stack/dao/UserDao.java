package com.tech.stack.dao;

import com.tech.stack.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangwei on 2018/5/9.
 */
@Repository
public interface UserDao {

    User getUser();
}
