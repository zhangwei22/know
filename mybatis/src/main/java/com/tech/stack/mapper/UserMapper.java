package com.tech.stack.mapper;

import com.tech.stack.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhangwei on 2018/5/8.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User LIMIT 1")
    User findUser();
}
