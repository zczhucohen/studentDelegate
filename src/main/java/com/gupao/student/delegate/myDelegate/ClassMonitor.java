package com.gupao.student.delegate.myDelegate;/**
 * Created by zhuochen on 2019/4/15.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuochen
 * @comment
 * @date 2019/4/15
 */
public class ClassMonitor {

    // 作为班长应该很好的了解老师布置的任务较给谁去做。
    Map<String,Student> executorStudent = new HashMap<>();

    public ClassMonitor() {
        executorStudent.put("收取语文作业",new StudentA());
        executorStudent.put("收取数学作业",new StudentB());
    }

    /**
     * 任务执行
     * @parameter [taskDefinition]
     * @return
     * @author zhuochen
     * @date 2019/4/15
     */
    public void executeTasks(String taskDefinition){
        executorStudent.get(taskDefinition).excuteTasks(taskDefinition);
    }
}
