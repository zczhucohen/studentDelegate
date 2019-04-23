package com.gupao.student.factory.abstractFactory;/**
 * Created by zhuochen on 2019/4/23.
 */

/**
 * 研发部门 - 职能信息
 * @author zhuochen
 * @comment
 * @date 2019/4/23
 */
public class IResearchDepartmentFunction implements FunctionInfo{
    @Override
    public void functionTasks() {
        System.out.println("研发信息");
    }
}
