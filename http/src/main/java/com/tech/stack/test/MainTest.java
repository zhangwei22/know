package com.tech.stack.test;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhangwei on 2018/5/14.
 */
public class MainTest {
    public static void main(String[] args) {

        /**
         * 如果捕获到异常，则下面的代码会执行
         * 如果异常没有被捕获，下面的代码不会执行
         * */
        String msg = null;
        System.out.println("这里是会执行的");
        try {
            msg = new String(null, "utf-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException");
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
            e.printStackTrace();
        }

        System.out.println("这里还执行吗？");
    }
}
