package com.gupao.studente.test.singleton;/**
 * Created by zhuochen on 2019/5/10.
 */

import com.gupao.student.singleton.lazy.LazySimpleSingleton;
import com.gupao.student.singleton.threadlocal.ThreadLocalSingleton;

/**
 * 验证单例线程
 * @author zhuochen
 * @comment
 * @date 2019/5/10
 */
public class ExecutorThreadLocal implements Runnable {
    @Override
    public void run() {

        ThreadLocalSingleton threadLocalSingleton = ThreadLocalSingleton.getInstance();

        System.out.println(Thread.currentThread().getName()+":"+threadLocalSingleton);
    }
}
