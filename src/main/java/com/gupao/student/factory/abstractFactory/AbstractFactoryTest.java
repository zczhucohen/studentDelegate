package com.gupao.student.factory.abstractFactory;/**
 * Created by zhuochen on 2019/4/23.
 */

/**
 * 抽象工厂测试
 * @author zhuochen
 * @comment
 * @date 2019/4/23
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        IDepartmentFactory iDepartmentFactory = new IResearchFactory();
        iDepartmentFactory.createFunctionInfo().functionTasks();
        iDepartmentFactory.createPerformance().performance();
    }
}
