package com.gupao.student.delegate.myDelegate;/**
 * Created by zhuochen on 2019/4/15.
 */

/**
 * 测试委派者模式
 * @author zhuochen
 * @comment
 * @date 2019/4/15
 */
public class TestStudentDetegate {

    public static void main(String[] args) {
        new Teacher().distributeTask("收取语文作业",new ClassMonitor());
    }
}
