package com.gupao.student.sqlhelper;
/**
 * Created by zhuochen on 2019/4/23.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * 自定义连接池 getInstance()返回POOL唯一实例，第一次调用时将执行构造函数
 * 构造函数Pool()调用驱动装载loadDrivers()函数；连接池创建createPool()函数 loadDrivers()装载驱动
 * createPool()建连接池，getConnection()返回一个连接实例 getConnection(long time)添加时间限制
 * freeConnection(Connection conn)将conn连接实例返回到连接池 getnum()返回空闲连接数
 * getnumActive()返回当前使用的连接数
 * @author zhuochen
 * @comment
 * @date 2019/4/23
 */
public abstract class Pool {
    // 配置文件名 com/gupao/student/sqlhelper/connection-INF.properties
    public String propertiesName = "connection-INF.properties";

    private static Pool instance = null; // 定义唯一实例

    /**
     * 最大连接数
     */
    protected int maxConnect = 100;

    /**
     * 保持连接数
     */
    protected int normalConnect = 10;

    /**
     * 驱动字符串
     */
    protected String driverName = null;

    /**
     * 驱动类
     */
    protected Driver driver = null; // 驱动变量

    /**
     * 私有构造函数，不允许外界访问
     */
    protected Pool(){
        try {
            init();
            loadDrivers(driverName);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 初始化所有从配置文件种读取的成员变量
     */
    private void init() throws IOException {
        String url = Thread.currentThread().getContextClassLoader().getResource(propertiesName).getFile();

        // 获取配置文件流
        // InputStream is = Pool.class.getResourceAsStream(propertiesName);
        InputStream is = new FileInputStream(url);
        Properties properties = new Properties();
        // 读取配置文件
        properties.load(is);
        this.driverName = properties.getProperty("driverName");
        this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));

    }

    /**
     * 装载和注册所有JDBC驱动程序 connection-INF.properties
     * @param driverName 接受驱动字符串
     */
    protected void loadDrivers(String driverName) {
        // 驱动字符串
        String driversClassName = driverName;

        try {
            driver = (Driver) Class.forName(driversClassName).newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册JDBC驱动程序"+driversClassName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("无法注册JDBC驱动程序:"+driversClassName+",错误:"+e);
        }

    }
    /**
     * 创建连接池
     */
    public abstract void createPool();

    /**
     * (单例模式)返回数据库连接池Pool的实例
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static synchronized Pool getInstance() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 单例模式，创建实例
        if(instance == null){
            instance.init();;
            instance = (Pool) Class.forName("com.gupao.student.sqlhelper.Pool").newInstance();
        }
        return instance;
    }

    /**
     * 获得一个可用的连接，如果没有则创建一个连接，且小于最大连接限制
     * @return
     */
    public abstract Connection getConnection();

    /**
     * 获得一个连接，有时间限制
     * @param time 设置该连接的持续时间（以毫秒为单位）
     * @return
     */
    public abstract Connection getConnection(long time);

    /**
     * 将连接对象返回给连接池
     * @param conn
     */
    public abstract void freeConnection(Connection conn);

    /**
     * 返回当前空闲连接数
     * @return
     */
    public abstract int getnum();

    /**
     * 返回当前工作的连接数
     * @return
     */
    public abstract int getnumActive();

    /**
     * 关闭所有连接，撤销驱动注册（此方法为单例方法）
     */
    public synchronized void release(){

        //撤销驱动
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销JDBC驱动程序"+driver.getClass().getName());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("无法撤销JDBC驱动程序的注册:"+driver.getClass().getName());
        }
    }

}
