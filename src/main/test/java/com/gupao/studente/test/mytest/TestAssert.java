package com.gupao.studente.test.mytest;/**
 * Created by zhuochen on 2019/5/14.
 */

/**
 * 测试断言
 * @author zhuochen
 * @comment
 * @date 2019/5/14
 */
public class TestAssert {

    private static boolean testQuery = true;
    public static void main(String[] args) {
        int i = 1;
        // 断言为true
        assert testQuery;
        System.out.println("断言搞定1"+testQuery);
        testQuery = false;
        assert i==1:"这个表达式不对";
        System.out.println("断言2"+testQuery);
        // javac TestAssert.java
    }
}
