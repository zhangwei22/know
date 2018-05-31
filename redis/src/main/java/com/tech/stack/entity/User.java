package com.tech.stack.entity;

/**
 * Created by zhangwei on 2018/5/31.
 */
public class User {
    private String name;
    private String email;
    private String pwd;
    private String wife;
    private String age;

    public User(String email, String name, String pwd, String wife, String age) {
        this.email = email;
        this.name = name;
        this.pwd = pwd;
        this.wife = wife;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
