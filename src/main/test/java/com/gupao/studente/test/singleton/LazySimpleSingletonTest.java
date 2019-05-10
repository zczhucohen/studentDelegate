package com.gupao.studente.test.singleton;/**
 * Created by zhuochen on 2019/5/10.
 */

/**
 * 懒汉线程不安全测试
 * @author zhuochen
 * @comment
 * @date 2019/5/10
 */
public class LazySimpleSingletonTest {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new ExecutorThread());
        Thread thread2 = new Thread(new ExecutorThread());
        thread1.start();
        thread2.start();
        System.out.println("End");
    }
}
