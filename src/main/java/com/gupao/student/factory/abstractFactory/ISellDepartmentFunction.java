package com.gupao.student.factory.abstractFactory;/**
 * Created by zhuochen on 2019/4/23.
 */

/**
 * 销售部门 - 职能信息
 * @author zhuochen
 * @comment
 * @date 2019/4/23
 */
public class ISellDepartmentFunction implements FunctionInfo{
    @Override
    public void functionTasks() {
        System.out.println("职能销售");
    }
}
