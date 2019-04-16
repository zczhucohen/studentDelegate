package com.gupao.student.factory;/**
 * Created by zhuochen on 2019/4/16.
 */

/**
 * 研发部门
 * @author zhuochen
 * @comment
 * @date 2019/4/16
 */
public class ResearchDepartment implements Department {

    @Override
    public void functionInfo() {
        System.out.println("我们负责公司研发新产品以及技术攻关");
    }
}
