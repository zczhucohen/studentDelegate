package com.gupao.student.singleton.lazy;/**
 * Created by zhuochen on 2019/5/8.
 */

/**
 *  懒汉式单例
 *  在外部需要时使用。简单的单例
 * @author zhuochen
 * @comment
 * @date 2019/5/8
 */
public class LazySimpleSingleton {

    // 静态块 ，公共内存区域
    private static LazySimpleSingleton lazy = null;
    // 构造方法需要私有化
    private LazySimpleSingleton() {
    }
    // 暂未加锁，线程不安全
    public synchronized static LazySimpleSingleton getInstance(){
        if(lazy == null){
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}
