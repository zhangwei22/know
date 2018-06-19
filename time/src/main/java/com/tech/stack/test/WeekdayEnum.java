package com.tech.stack.test;

/**
 * Created by zhangwei on 2018/6/19.
 */
public enum WeekdayEnum {
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY(
            "星期六"), SUNDAY("星期日");//记住要用分号结束

    private String desc;//描述

    /**
     * 私有构造方法，防止被外部调用
     * 构造方法是由编译器调用
     *
     * @param desc
     */
    private WeekdayEnum(String desc) {
        this.desc = desc;
    }

    /**
     * 定义方法，返回描述，跟常规类的定义没区别
     *
     * @return
     */
    public String getDesc() {
        return desc;
    }

    public static void main(String[] args) {
        for (WeekdayEnum weekdayEnum : WeekdayEnum.values()) {
            System.out.println("name:" + weekdayEnum.name() + ", desc:" + weekdayEnum.getDesc());
        }
    }

}
