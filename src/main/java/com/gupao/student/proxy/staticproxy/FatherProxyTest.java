package com.gupao.student.proxy.staticproxy;

/**
 * 静态代理测试
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 */
public class FatherProxyTest {

    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();

        // 三层架构 每天都在用一种静态代理形式
        // 对数据库进行分库分表
        //ThreadLocal
        // 进行数据源动态切换

    }
}
