package com.gupao.student.factory.method;/**
 * Created by zhuochen on 2019/4/16.
 */

import com.gupao.student.factory.Department;

/**
 * 测试工厂方法
 * @author zhuochen
 * @comment
 * @date 2019/4/16
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        DepartmentFactory departmentFactory = new ResearchFactory();
        Department department = departmentFactory.create();
        department.functionInfo();

        departmentFactory = new SellFactory();
        department = departmentFactory.create();
        department.functionInfo();
    }
}
