package com.tech.stack.test;

/**
 * Created by zhangwei on 2018/6/19.
 */
public class SwitchTest {

    /**
     * 测试传null到switch会发生什么
     * 试验结果：报空指针异常（虽然有default部分）
     */
    public static void main(String[] args) {
        Integer stat = null;
        switch (stat) {
        case 1:
            System.out.println("111");
        default:
            System.out.println("default");
        }
    }
}
