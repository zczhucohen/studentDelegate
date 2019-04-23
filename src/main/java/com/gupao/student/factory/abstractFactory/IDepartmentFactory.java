package com.gupao.student.factory.abstractFactory;

/**
 * 抽象工厂
 * @author zhuochen
 * @comment
 * @date 2019/4/16
 */
public interface IDepartmentFactory {
    // 创建一个产品族
    public FunctionInfo createFunctionInfo();

    public PerformanceInfo createPerformance();
}
