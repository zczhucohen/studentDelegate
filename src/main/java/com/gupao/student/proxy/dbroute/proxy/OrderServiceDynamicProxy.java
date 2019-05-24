package com.gupao.student.proxy.dbroute.proxy;

import com.gupao.student.proxy.dbroute.db.DynamicDataSourceEntity;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用动态代理
 * @author zhuochen
 * @comment
 * @date 2019/5/24
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat year = new SimpleDateFormat("yyyy");

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object invoke = method.invoke(target, args);
        after();
        return invoke;

    }

    private void after() {
        System.out.println("Proxy after method");
        DynamicDataSourceEntity.restore();
    }
    // target应该是原对象order
    private void before(Object target) {

        System.out.println("Proxy before method");
        try {
            Long getCreateTime = (Long)target.getClass().
                    getMethod("getCreateTime").invoke(target);
            Integer dbRouter = Integer.valueOf(year.format(new Date(getCreateTime)));
            System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
            DynamicDataSourceEntity.set(dbRouter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
