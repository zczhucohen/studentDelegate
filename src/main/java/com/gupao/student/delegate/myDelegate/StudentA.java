package com.gupao.student.delegate.myDelegate;/**
 * Created by zhuochen on 2019/4/15.
 */

/**
 * 语文课代表 ChineseClassRepresentative
 * @author zhuochen
 * @comment
 * @date 2019/4/15
 */
public class StudentA implements Student{


    @Override
    public void excuteTasks(String taskDefinition) {
        System.out.println("我是学生A，我负责："+taskDefinition+"任务");
    }
}
