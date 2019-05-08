package com.gupao.student.singleton.hungry;/**
 * Created by zhuochen on 2019/5/8.
 */

/**
 * 饿汉式
 * 静态代码块
 * ConcurrentExecutor
 * @author zhuochen
 * @comment
 * @date 2019/5/8
 */
public class HungryStaticSingleton {

    private static HungryStaticSingleton hungryStaticSingleton = null;
    // 代码块
    static {
        hungryStaticSingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
    }
    public static HungryStaticSingleton getInstance(){return hungryStaticSingleton;}
}
