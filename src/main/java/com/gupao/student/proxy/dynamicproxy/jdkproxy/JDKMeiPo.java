package com.gupao.student.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 */
public class JDKMeiPo implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    private void before() {
        System.out.println("婚姻介绍所，开始找对象，现在已经确认你的需求");
        System.out.println("开始寻找");
    }

    private void after() {
        System.out.println("ok的话，准备接触");
    }
}
