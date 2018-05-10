package com.tech.stack.mapper;

import com.tech.stack.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhangwei on 2018/5/10.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT `id`, `name`, `age`, `sex` FROM user LIMIT 1")
    User findUser();

    @Insert("INSERT INTO user (`name`, `age`, `sex`) VALUES (#{name}, #{age}, #{sex})")
    void saveUser(User user);
}
