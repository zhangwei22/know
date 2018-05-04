package com.tech.stack.test;

import com.tech.stack.entity.Student;

/**
 * Created by zhangwei on 2018/5/4.
 *
 * @description 直接创建对象跟用反射创建对象性能对比
 * <p>
 * 反射的优点：提高了程序的灵活性和扩展性，在底层框架中用的比较多，业务层面的开发过程中尽量少用
 * 反射的缺点：性能不好。反射是一种解释操作，用于字段和方法接入时要远慢于直接代码
 */
public class Test002 {

    /**
     * 直接创建对象
     */
    public static void createByNew() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Student student = new Student();
            student.setName("测试");
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    /**
     * 利用反射创建对象
     */
    public static void createByReflection() {
        long start = System.currentTimeMillis();
        Class<?> clz = null;
        for (int i = 0; i < 100000; i++) {
            try {
                clz = Class.forName("com.tech.stack.entity.Student");
                Student student = (Student) clz.newInstance();
                student.setName("测试");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    /**
     * 测试主方法
     */
    public static void main(String[] args) {
        Test002.createByNew();
        Test002.createByReflection();
    }
}
