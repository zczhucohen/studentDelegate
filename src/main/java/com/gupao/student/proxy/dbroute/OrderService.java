package com.gupao.student.proxy.dbroute;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 */
public class OrderService implements IorderService {

    private OrderDao orderDao;

    public OrderService() {
        // 为了方便，，在此注入
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用orderDao创建订单");
        // int insert = orderDao.insert();
        return orderDao.insert(order);
    }
}
