package com.gupao.student.proxy.dbroute;

import com.gupao.student.proxy.dbroute.proxy.OrderServiceStaicProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 */
public class DbRouteProxyTest {

    public static void main(String[] args) {
        try {
            Order order = new Order();
            order.setCreateTime(new Date().getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date parse = sdf.parse("2018");
            order.setCreateTime(parse.getTime());
            new OrderServiceStaicProxy(new OrderService()).createOrder(order);
        }catch (Exception e){
            e.printStackTrace();;
        }

    }
}
