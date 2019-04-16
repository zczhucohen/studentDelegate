package com.gupao.student.factory;/**
 * Created by zhuochen on 2019/4/16.
 */

/**
 * 市场部 销售
 * @author zhuochen
 * @comment
 * @date 2019/4/16
 */
public class SellDepartment implements Department {

    @Override
    public void functionInfo() {
        System.out.println("我负责公司产品的销售职能");
    }
}
