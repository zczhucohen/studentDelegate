package com.gupao.student.sqlhelper;/**
 * Created by zhuochen on 2019/4/26.
 */

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 *  数据库连接管理类
 * @author zhuochen
 * @comment
 * @date 2019/4/26
 */
public class ConManager {

    private static Pool dbPool;

    private static ConManager instance = null; // 单例对象

    /**
     * 私有构造方法，禁止外部创建本类对象，想要获得本类对象，通过<code>getInstance()</code>方法 使用了设计模式中的单例模式
     */

    private ConManager(){

    }

    /**
     * 释放数据库连接对象
     */
    protected static void closeConn(Connection conn){dbPool.freeConnection(conn);}

    /**
     * 返回当前连接管理类的一个对象
     */
    private static ConManager getInstance(){
        if(null == instance){
            instance = new ConManager();
        }
        return instance;
    }

    /**
     * 从自定义数据库连接池中获得一个连接对象
     * @return
     */
    protected static Connection getConnection(){

        Connection conn = null;

        try {
            if(dbPool == null){
                dbPool = DBConnectionPool.getInstance();
            }
            conn = dbPool.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 使用 JNDI 从容器的数据库连接池中获得一个连接对象
     * accessPool 是否通过容器连接池获得连接
     * Tomcat 容器的字符串 "java:com/env/...(数据源名)"
     * @param lookupStr
     * @return
     */
    protected static Connection getConnection(String lookupStr){
        Connection conn = null;
        try {
            ConManager.getInstance();
            // 使用JNDI从Tomcat容器的数据库连接池中获得一个连接对象
            Context ct = new InitialContext();
            DataSource ds = (DataSource) ct.lookup(lookupStr);
            conn = ds.getConnection();

        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

}
