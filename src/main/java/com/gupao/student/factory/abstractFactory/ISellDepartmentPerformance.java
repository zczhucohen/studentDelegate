package com.gupao.student.factory.abstractFactory;/**
 * Created by zhuochen on 2019/4/23.
 */

/**
 * 销售部门 - 业绩能力
 * @author zhuochen
 * @comment
 * @date 2019/4/23
 */
public class ISellDepartmentPerformance implements PerformanceInfo{
    @Override
    public void performance() {
        System.out.println("业绩能力信息");
    }
}
