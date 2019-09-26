package com.tech.stack.singleton;

/**
 * Created by zhangwei on 2018/5/29.
 * <p>
 * 单例模式：静态内部类实现
 */
public class StaticInnerClass {
    private static class InstanceInit {
        private static StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return InstanceInit.instance;
    }
}
