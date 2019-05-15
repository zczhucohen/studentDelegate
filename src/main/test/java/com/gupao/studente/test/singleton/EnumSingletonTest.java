package com.gupao.studente.test.singleton;/**
 * Created by zhuochen on 2019/5/15.
 */

import com.gupao.student.singleton.register.EnumSingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举测试类
 * @author zhuochen
 * @comment
 * @date 2019/5/15
 */
public class EnumSingletonTest {

    /*public static void main(String[] args) {
        try {
            EnumSingleton instance1 = null;
            EnumSingleton instance2 = EnumSingleton.getInstance();
            instance2.setData(new Object());

            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance1 = (EnumSingleton)ois.readObject();
            ois.close();

            System.out.println(instance1.getData());
            System.out.println(instance2.getData());
            System.out.println(instance1.getData() == instance2.getData());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args) {

        try {
            // 反射也不行，会报错。完全单例
            Class<EnumSingleton> singletonClass = EnumSingleton.class;
            Constructor<EnumSingleton> declaredConstructor = singletonClass.getDeclaredConstructor(String.class, int.class);
            declaredConstructor.setAccessible(true);
            EnumSingleton enumSingleton = declaredConstructor.newInstance("Tom", 18);

            System.out.println(enumSingleton);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
