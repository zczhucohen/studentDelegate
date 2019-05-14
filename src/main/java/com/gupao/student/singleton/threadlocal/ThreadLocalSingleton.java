package com.gupao.student.singleton.threadlocal;/**
 * Created by zhuochen on 2019/5/14.
 */

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/14
 */
public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> threadlocalSingleton =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance(){return threadlocalSingleton.get();}
}
