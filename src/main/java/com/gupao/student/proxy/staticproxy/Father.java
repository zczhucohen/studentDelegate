package com.gupao.student.proxy.staticproxy;

import com.gupao.student.proxy.Person;

/**
 * 静态代理
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 */
public class Father implements Person {

    private Person person;

    public Father(Person person) {
        this.person = person;
    }

    @Override
    public void findLove() {
        System.out.println("父亲物色对象");
        this.person.findLove();
        System.out.println("都同意，皆大欢喜！");
    }
}
