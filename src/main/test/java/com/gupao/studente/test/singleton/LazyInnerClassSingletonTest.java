package com.gupao.studente.test.singleton;/**
 * Created by zhuochen on 2019/5/14.
 */

import com.gupao.student.singleton.lazy.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;

/**
 * 懒汉内部类测试
 * @author zhuochen
 * @comment
 * @date 2019/5/14
 */
public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {
        try {
            // 很无聊的情况下进行破坏
            Class<?> clazz = LazyInnerClassSingleton.class;
            // 通过反射拿到私有的构造方法
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(null);
            // 强制访问，强吻，不愿意也要吻
            declaredConstructor.setAccessible(true);

            // 暴力初始化
            Object o1 = declaredConstructor.newInstance();

            // 调用了两次构造方法，相当于new了两次
            // 违反了原则性问题
            // 构造函数有判断 已不被允许多次创建
            Object o2 = declaredConstructor.newInstance();
            System.out.println(o1 == o2);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
