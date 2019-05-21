package com.gupao.student.proxy.dynamicproxy.jdkproxy;

import com.gupao.student.proxy.Person;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm以上");
        System.out.println("有六块腹肌");
    }
}
