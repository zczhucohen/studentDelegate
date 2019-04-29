package com.gupao.student.sqlhelper;
/**
 * Created by zhuochen on 2019/4/26.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * 数据库连接池管理类
 * @author zhuochen
 * @comment
 * @date 2019/4/26
 */
public class DBConnectionPool extends Pool{

    private int checkedOut; // 正在使用的连接数

    /**
     * 存放产生的连接对象容器
     */
    private Vector<Connection> freeConnections = new Vector<Connection>(); // 存放产生的连接对象容器

    private String passWord = null; // 密码

    private String url = null; // 连接字符串

    private String userName = null; // 用户名

    private static int num = 0; // 空闲连接数

    private static int numActive = 0; // 当前可用的连接数

    private static DBConnectionPool pool =  null; // 连接池实例变量

    /**
     * 产生数据库连接池
     */
    public static DBConnectionPool getInstance(){
        // 单例 双重验证
        if(pool == null){
            synchronized (DBConnectionPool.class){
                if(pool == null){
                    pool = new DBConnectionPool();
                }
            }
        }
        return pool;
    }
    /**
     * 获得一个 数据库连接池的实例
     */
    private DBConnectionPool(){

        try {
            init();
            for (int i = 0; i<normalConnect; i++){
                Connection c = newConnection();
                if(c != null){
                    freeConnections.add(c);
                    num++;
                }
            }

        }catch (Exception e){

        }

    }

    /**
     * 创建一个新的连接
     * @return
     */
    private Connection newConnection() {
        Connection cn = null;
        try {
            if(userName == null){
                cn = DriverManager.getConnection(url);
            }else{
                cn = DriverManager.getConnection(url,userName,passWord);
            }
            System.out.println("连接池创建了一个新的连接");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("无法创建这个URL的连接:"+url);
        }

        return cn;
    }

    /**
     *
     */
    private void init()throws IOException {
        String url = Thread.currentThread().getContextClassLoader().getResource(propertiesName).getFile();

        // 获取配置文件流
        // InputStream is = Pool.class.getResourceAsStream(propertiesName);
        InputStream is = new FileInputStream(url);
        // InputStream is = DBConnectionPool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.userName = p.getProperty("userName");
        this.passWord = p.getProperty("passWord");
        this.driverName = p.getProperty("driverName");
        this.url = p.getProperty("url");
        this.driverName = p.getProperty("driverName");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));


    }

    /**
     * 如果不再使用某个连接对象时，可调用此方法将该对象释放到 连接池
     * @param conn
     */
    @Override
    public synchronized void freeConnection(Connection conn) {
        freeConnections.add(conn);
        num++;
        checkedOut--;
        numActive--;
        notifyAll(); // 解锁
    }

    @Override
    public int getnum() {
        return num; // 空闲连接
    }

    @Override
    public int getnumActive() {
        return numActive; // 当前连接数
    }

    /**
     * （单例模式）获取一个可用的连接
     * @return
     */
    @Override
    public synchronized Connection getConnection() {
        Connection con = null;
        if(freeConnections.size()>0){ // 还有空闲的连接
            num--;
            con = (Connection)freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try {
                if(con.isClosed()){
                    System.out.println("从连接池删除一个无效的连接");
                    con = getConnection();
                }
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("从连接池删除一个无效的连接");
                con = getConnection();
            }
        }else if(maxConnect == 0 || checkedOut < maxConnect){ // 没有空闲连接且当前连接小于最大允许值，最大值为0则不限制
            con = newConnection();
        }
        if(con != null){
            checkedOut++;
        }
        numActive++;
        return con;
    }

    @Override
    public synchronized Connection getConnection(long timeOut) {
        long startTime = new Date().getTime();
        Connection con;
        while ((con = getConnection()) == null){

            try {
                wait(timeOut); // 线程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if((new Date().getTime() -startTime) >= timeOut){
                return null; // 如果超时，则返回null;
            }
        }
        return con;
    }

    /**
     * 关闭所有连接
     */
    public synchronized void release(){
        try {
            // 将当前连接赋值到枚举中
            Enumeration<Connection> elements = freeConnections.elements();
            // 使用循环关闭所有连接
            while (elements.hasMoreElements()){
                // 如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素
                Connection connection = elements.nextElement();
                try {
                    connection.close();
                    num--;
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("无法关闭连接池中的连接");
                }
            }
            freeConnections.removeAllElements();
            numActive=0;
        }finally {
            super.release();
        }
    }

    /**
     * 建立连接池
     */
    @Override
    public void createPool() {
        pool = new DBConnectionPool();
        if(pool != null){
            System.out.println("连接池创建成功");
        }else {
            System.out.println("连接池创建失败");
        }
    }
}
