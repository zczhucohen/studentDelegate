package com.gupao.student.factory.abstractFactory;/**
 * Created by zhuochen on 2019/4/23.
 */

/**
 * @author zhuochen
 * @comment
 * @date 2019/4/23
 */
public class ISellFactory implements IDepartmentFactory {
    @Override
    public FunctionInfo createFunctionInfo() {
        return new ISellDepartmentFunction();
    }

    @Override
    public PerformanceInfo createPerformance() {
        return new ISellDepartmentPerformance();
    }
}
