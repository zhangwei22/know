package com.tech.stack.algorithm.digui;

/**
 * Created by zhangwei on 2019/4/14.
 */
public class MainTest {
    public static int M(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return M(a + a, b / 2);
        }
        return M(a + a, b / 2) + a;
    }

    public static void main(String[] args) {
        System.out.println(M(2, 25));
        System.out.println(M(3, 11));
    }
}
