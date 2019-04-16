package com.gupao.student.factory.simple;/**
 * Created by zhuochen on 2019/4/16.
 */

import com.gupao.student.factory.Department;
import com.gupao.student.factory.SellDepartment;

/**
 * 简单工厂测试
 * @author zhuochen
 * @comment
 * @date 2019/4/16
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        DepartmentSimpleFactory departmentSimpleFactory = new DepartmentSimpleFactory();
        /*Department research = departmentSimpleFactory.create("research");
        research.functionInfo();*/
       /* Department departmentSimpleFactoryNew = departmentSimpleFactory.createNew("com.gupao.student.factory.SellDepartment");
        departmentSimpleFactoryNew.functionInfo();*/
        Department departmentIntance = departmentSimpleFactory.createInstance(SellDepartment.class);
        departmentIntance.functionInfo();;
    }
}
