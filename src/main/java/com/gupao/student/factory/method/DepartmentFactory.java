package com.gupao.student.factory.method;/**
 * Created by zhuochen on 2019/4/16.
 */

import com.gupao.student.factory.Department;

/**
 * 部门工厂创建
 * @author zhuochen
 * @comment
 * @date 2019/4/16
 */
public interface DepartmentFactory {

    public Department create();
}
