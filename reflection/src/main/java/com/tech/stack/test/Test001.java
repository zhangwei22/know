package com.tech.stack.test;

import com.tech.stack.entity.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zhangwei on 2018/5/4.
 *
 * @description 反射的一些基本操作
 */
public class Test001 {
    /**
     * 获取类中的所有方法
     * 这里会获取父类中的方法
     */
    public void getAllMethod() {
        try {
            Class<?> clz = Class.forName("com.tech.stack.entity.Student");
            Method[] methods = clz.getMethods();
            for (Method method : methods) {
                System.out.println("方法名：" + method.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取类中定义的所有方法
     * 这里不会获取父类中的方法
     */
    public void getAllDeclaredMethod() {
        try {
            Class<?> clz = Class.forName("com.tech.stack.entity.Student");
            Method[] methods = clz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("方法名：" + method.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取方法的其他相关信息
     */
    public void getMethodInfo() {
        try {
            Class<?> clz = Class.forName("com.tech.stack.entity.Student");
            Method[] methods = clz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("方法名：" + method.getName());
                System.out.println("方法返回类型：" + method.getReturnType().getName());
                System.out.println("方法修饰符：" + method.getModifiers());
                System.out.println("方法参数信息：" + method.getParameters());
                System.out.println("方法上的注解：" + method.getAnnotations());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 操作方法
     */
    public void invokeMethod() {
        try {
            Class<?> clz = Class.forName("com.tech.stack.entity.Student");
            Student student = (Student) clz.newInstance();
            System.out.println("name：" + student.getName());
            Method method = clz.getMethod("setName", String.class);
            method.invoke(student, "科比`布莱恩特");
            System.out.println("name：" + student.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取类中的所有属性
     * getFields()只能获取public的属性，包括父类的，所以没有输出
     */
    public void getAllPublicField() {
        try {
            Class<?> clz = Class.forName("com.tech.stack.entity.Student");
            Field[] fields = clz.getFields();
            for (Field field : fields) {
                System.out.println("属性值：" + field.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取声明的各种字段，包括public、protected、private得用getDeclaredFields()
     */
    public void getAllDeclaredField() {
        try {
            Class<?> clz = Class.forName("com.tech.stack.entity.Student");
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("属性值：" + field.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取属性的相关信息
     */
    public void getFieldInfo() {
        try {
            Class<?> clz = Class.forName("com.tech.stack.entity.Student");
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("属性值：" + field.getName());
                System.out.println("属性类型：" + field.getType().getName());
                System.out.println("属性修饰符：" + field.getModifiers());
                System.out.println("属性上的注解：" + field.getAnnotations());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 操作属性
     */
    public void opaerteField() {
        try {
            Class<?> clz = Class.forName("com.tech.stack.entity.Student");
            Student student = (Student) clz.newInstance();
            Field field = clz.getDeclaredField("name");
            field.setAccessible(true);
            System.out.println("name：" + field.get(student));
            field.set(student, "科比`布莱恩特");
            System.out.println("name：" + field.get(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试主方法
     */
    public static void main(String[] args) {
        Test001 test001 = new Test001();
        //        test001.getAllMethod();
        //        test001.getAllDeclaredMethod();
        //        test001.getMethodInfo();
        //        test001.invokeMethod();
        //        test001.getAllPublicField();
        //        test001.getAllDeclaredField();
        //        test001.getFieldInfo();
        test001.opaerteField();
    }
}
