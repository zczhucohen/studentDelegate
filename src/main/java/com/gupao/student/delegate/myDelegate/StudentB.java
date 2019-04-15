package com.gupao.student.delegate.myDelegate;/**
 * Created by zhuochen on 2019/4/15.
 */

/**
 * 数学课代表 ChineseClassRepresentative
 * @author zhuochen
 * @comment
 * @date 2019/4/15
 */
public class StudentB implements Student{

    @Override
    public void excuteTasks(String taskDefinition) {
        System.out.println("我是学生B，负责："+taskDefinition+"任务");
    }
}
