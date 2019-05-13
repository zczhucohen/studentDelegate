package com.gupao.student.singleton.lazy;/**
 * Created by zhuochen on 2019/5/13.
 */

/**
 * 懒汉式，静态内部类
 * 这种形式兼顾饿汉式的内存浪费，也兼顾了synchronized性能问题
 * 完美地屏蔽了这两个缺点
 * 史上最牛B的单例模式的实现方式
 * @author zhuochen
 * @comment
 * @date 2019/5/13
 */
public class LazyInnerClassSingleton {
    // 默认使用LazyInnerClassGeneral的时候，会先初始化内部类
    // 如果没使用的话，内部类是不加载的
    private LazyInnerClassSingleton(){
        if(innerSingleton.LAZY != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }
    // 每一个关键字都不是多余的
    // static是为了使单例的空间共享
    // final 保证这个方法不会被重写，重载
    public static final LazyInnerClassSingleton getInstance(){
        return innerSingleton.LAZY;
    }

    // 默认类不加载
    private static class innerSingleton{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
