package com.gupao.student.delegate.myDelegate;/**
 * Created by zhuochen on 2019/4/15.
 */

/**
 * 练习委派模式
 * @author zhuochen
 * @comment
 * @date 2019/4/15
 */
public class Teacher {
    /**
     * 老师布置任务，分发给班长。
     * @parameter [taskDefinition 任务内容, classMonitor 班长]
     * @return
     * @author zhuochen
     * @date 2019/4/15
     */
    public void distributeTask(String taskDefinition,ClassMonitor classMonitor){
        classMonitor.executeTasks(taskDefinition);
    }
}
