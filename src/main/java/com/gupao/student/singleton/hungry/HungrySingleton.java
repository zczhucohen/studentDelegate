package com.gupao.student.singleton.hungry;/**
 * Created by zhuochen on 2019/5/8.
 */

/**
 * 饿汉式单例
 * 在类加载的时候就立即初始化了，并且创建单例对象
 * //优点：
 *        没有加任何的锁、执行效率比较高，在用户体验上比懒汉式更好
 * //缺点：
 *        类加载的时候就初始化了，不管用不用都占用空间
 *        浪费了内存，占着茅坑不拉屎
 * @author zhuochen
 * @comment
 * @date 2019/5/8
 *
 * 绝对线程安全，在线程还没有出现以前就实例化了，不可能存在访问安全问题。
 */
public class HungrySingleton {
    //先静态，后动态
    // 先属性、后方法
    // 先上后下
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
