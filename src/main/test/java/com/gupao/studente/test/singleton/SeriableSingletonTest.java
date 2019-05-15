package com.gupao.studente.test.singleton;/**
 * Created by zhuochen on 2019/5/15.
 */

import com.gupao.student.singleton.seriable.SeriableSingleton;

import java.io.*;

/**
 * 序列化单例测试
 * @author zhuochen
 * @comment
 * @date 2019/5/15
 */
public class SeriableSingletonTest {

    public static void main(String[] args) {

        SeriableSingleton instance1 = null;
        SeriableSingleton instance2 = SeriableSingleton.INSTANCE;
        try {
            FileOutputStream fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            oos.flush();
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance1 = (SeriableSingleton) ois.readObject();
            ois.close();
            fis.close();

            System.out.println(instance1);
            System.out.println(SeriableSingleton.INSTANCE.getClass());
            System.out.println(SeriableSingleton.INSTANCE == instance1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
