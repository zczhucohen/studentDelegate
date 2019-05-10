package com.gupao.studente.test.singleton;/**
 * Created by zhuochen on 2019/5/10.
 */

import com.gupao.student.singleton.lazy.LazySimpleSingleton;

/**
 * 线程验证懒汉不安全
 * @author zhuochen
 * @comment
 * @date 2019/5/10
 */
public class ExecutorThread implements Runnable {
    @Override
    public void run() {
        LazySimpleSingleton lazySimpleSingleton = LazySimpleSingleton.getInstance();

        System.out.println(Thread.currentThread().getName()+":"+lazySimpleSingleton);
    }
}
