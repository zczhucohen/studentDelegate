package com.gupao.studente.test.singleton;/**
 * Created by zhuochen on 2019/5/15.
 */

import com.gupao.student.singleton.threadlocal.ThreadLocalSingleton;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/15
 */
public class ThreadLoaclSingletonTest {

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread thread1 = new Thread(new ExecutorThreadLocal());
        Thread thread2 = new Thread(new ExecutorThreadLocal());
        thread1.start();;
        thread2.start();
        System.out.println("end");
    }
}
