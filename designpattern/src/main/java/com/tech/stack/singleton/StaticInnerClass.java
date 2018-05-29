package com.tech.stack.singleton;

/**
 * Created by zhangwei on 2018/5/29.
 *
 * @desc 单例模式：静态内部类
 */
public class StaticInnerClass {
    private static class InstanceInit {
        private static StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return InstanceInit.instance;
    }
}
