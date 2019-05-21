package com.gupao.student.proxy.dbroute;

/**
 * 实体类
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 */
public class Order {

    private Object orderInfo;
    // 订单创建时间进行按年分库
    private Long createTime;
    private String id;

    public Order() {
    }

    public Order(Object orderInfo, Long createTime, String id) {
        this.orderInfo = orderInfo;
        this.createTime = createTime;
        this.id = id;
    }

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
