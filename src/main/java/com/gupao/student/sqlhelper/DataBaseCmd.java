package com.gupao.student.sqlhelper;/**
 * Created by zhuochen on 2019/4/29.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 数据库操作类
 * 包含两个构造函数
 * 使用自定义连接池获得连接
 * 制定JNDI的数据源名称
 * @author zhuochen
 * @comment
 * @date 2019/4/29
 */
public class DataBaseCmd {

    private PreparedStatement pstm = null; // 连接语句

    private Connection con = null; // 获得连接对象

    private ResultSet rs = null; // 结果集

    private String dataSource = null; // 指定使用的数据源

    /**
     * 默认构造器
     */
    public DataBaseCmd(){

    }

    /**
     * 构造器
     * @param dataSource 指定使用的JNDI查找的数据源名称
     * Tomcat 的数据源名为 java：comp/env/test
     */
    public DataBaseCmd(String dataSource){this.dataSource = dataSource;}

    /**
     * 初始化数据库连接对象
     */
    private synchronized void initCon(){

        try {
            if(null == con){
                if(null == dataSource || "".equals(dataSource)){
                    con = ConManager.getConnection();
                }else{
                    con = ConManager.getConnection(dataSource);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 查询表格方法，此方法一般将单表中所有的数据查询出来，如果需要匹配查询条件，则最好在业务逻辑层或者界面层做
     * 数据解析或者查询语句中直接带条件
     * @param sql 要执行的sql语句 或者存储过程的名称
     * @param cmdType 指定sql参数的类型，：true为存储过程，false为sql语句
     * @param values 指定sql语句中的参数列表
     * @return 返回更新后的结果集
     */
    public ResultSet excuteQuery(String sql,boolean cmdType,List values) throws SQLException {
        try {
            initCon();
            // 存储过程处理
            if(cmdType){
                pstm = con.prepareCall(sql); // 处理存储过程的语句集
            }else{
                pstm = con.prepareStatement(sql);
            }
            if(values != null && values.size() > 0){
                setValues(pstm,values);
            }
            rs = pstm.executeQuery();
            return rs;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 关闭连接
     */
    public void closeConnection(){
        try {
            if(null != con && !con.isClosed()){
                ConManager.closeConn(con);
                con = null;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 关闭语句集
     */
    public void closePstmt(){
        if(null != pstm){
            try {
                pstm.close();
                pstm = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭结果集
     */
    public void closeResultSet(){
        if(null != rs){
            try {
                rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭所有数据库访问对象
     */
    public void closeAll(){
        closePstmt();
        closeResultSet();
        closeConnection();
    }

    /**
     * 设定语句 的参数
     * @param pstm 语句集 对象
     * @param values 指定 sql语句中的参数列表
     */
    private void setValues(PreparedStatement pstm,List values) throws SQLException {

        for(int i = 0;i < values.size(); i++){
            Object o = values.get(i);
            pstm.setObject(i+1,o);
        }
    }

    /**
     * (不建议使用的方法)使用JNDI的方式获取数据源时应使用此方法
     * 建议在构造器中直接传递参数
     * @param dataSource 数据库连接使用的数据源名称
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
}
