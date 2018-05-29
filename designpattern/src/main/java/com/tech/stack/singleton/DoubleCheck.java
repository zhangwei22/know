package com.tech.stack.singleton;

/**
 * Created by zhangwei on 2018/5/29.
 * <p>
 * 单例模式：双重校验
 */
public class DoubleCheck {
    //为了防止JVM的即时编译器进行指令重排序优化，而导致双重检查锁失效，需要添加volatile关键字
    private volatile static DoubleCheck instance;

    //防止在外面以new的方式创建对象
    private DoubleCheck() {
    }

    public static DoubleCheck getInstance() {
        //判断减少同步
        if (instance == null) {
            //模拟初始化对象的准备时间
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //同步控制并发
            synchronized (DoubleCheck.class) {
                //判断避免重复创建
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
