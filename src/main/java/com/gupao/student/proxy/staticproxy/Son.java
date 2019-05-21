package com.gupao.student.proxy.staticproxy;

import com.gupao.student.proxy.Person;

/**
 *  静态代理
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 */
public class Son implements Person {

    @Override
    public void findLove() {
        System.out.println("肤白貌美大长腿！");
    }
}
