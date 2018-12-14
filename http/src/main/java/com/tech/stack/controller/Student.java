package com.tech.stack.controller;

/**
 * Created by zhangwei on 2018/11/18.
 */
public class Student {
    private String id;
    private String stdId;
    private String stdName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = HttpController.username;
    }
}
