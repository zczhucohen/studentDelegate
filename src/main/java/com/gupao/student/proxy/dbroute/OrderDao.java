package com.gupao.student.proxy.dbroute;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 */
public class OrderDao {
    public int insert(Order order){
        System.out.println("数据库新增成功");
        return 1;
    }
}
