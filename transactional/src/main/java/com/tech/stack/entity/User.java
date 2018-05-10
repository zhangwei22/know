package com.tech.stack.entity;

/**
 * Created by zhangwei on 2018/5/10.
 */
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String sex;

    public User() {
        // 如果覆盖了默认的构造方法而不重新定义无参的构造方法会报如下异常
        // org.apache.ibatis.executor.ExecutorException: No constructor found in com.tech.stack.entity.User matching [java.lang.Long, java.lang.String, java.lang.Integer, java.lang.String]
    }

    public User(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", sex=" + this.sex;
    }
}
