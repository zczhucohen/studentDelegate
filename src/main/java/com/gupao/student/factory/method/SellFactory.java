package com.gupao.student.factory.method;/**
 * Created by zhuochen on 2019/4/16.
 */

import com.gupao.student.factory.Department;
import com.gupao.student.factory.SellDepartment;

/**
 * 销售部门创建
 * @author zhuochen
 * @comment
 * @date 2019/4/16
 */
public class SellFactory implements DepartmentFactory{
    @Override
    public Department create() {
        return new SellDepartment();
    }
}
