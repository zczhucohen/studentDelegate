package com.gupao.student.factory.abstractFactory;/**
 * Created by zhuochen on 2019/4/23.
 */

/**
 * 研发部门- 业绩能力
 * @author zhuochen
 * @comment
 * @date 2019/4/23
 */
public class IRsearchDepartmentPerformance implements PerformanceInfo{

    @Override
    public void performance() {
        System.out.println("研发业绩信息");
    }

}
