package com.tech.stack.entity;

/**
 * Created by zhangwei on 2018/5/4.
 */
public class Word {
    private Long id;
    private String bYear;
    private String lYear;
    private String leader;
    private String phone;
    private String curYear;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getbYear() {
        return bYear;
    }

    public void setbYear(String bYear) {
        this.bYear = bYear;
    }

    public String getlYear() {
        return lYear;
    }

    public void setlYear(String lYear) {
        this.lYear = lYear;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCurYear() {
        return curYear;
    }

    public void setCurYear(String curYear) {
        this.curYear = curYear;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
