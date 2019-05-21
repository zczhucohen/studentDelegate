package com.gupao.student.proxy.dbroute.proxy;

import com.gupao.student.proxy.dbroute.IorderService;
import com.gupao.student.proxy.dbroute.Order;
import com.gupao.student.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 静态代理
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 */
public class OrderServiceStaicProxy implements IorderService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    private IorderService iorderService;

    public OrderServiceStaicProxy(IorderService iorderService) {
        this.iorderService = iorderService;
    }

    @Override
    public int createOrder(Order order) {
        Long createTime = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(sdf.format(new Date(createTime)));
        System.out.println("静态代理类自动分配到[DB_"+dbRouter+"]数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);
        this.iorderService.createOrder(order);
        DynamicDataSourceEntity.restore();
        return 0;
    }
}
