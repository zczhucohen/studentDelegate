package com.gupao.student.proxy.dbroute.db;

/**
 * 单例数据源类
 * 线程单例
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 * DynamicDataSourceEntity
 */
public class DynamicDataSourceEntity {

    private final static String DEFAULT_SOURCE = null;

    private static final ThreadLocal<String> datasource = new ThreadLocal<>();

    private DynamicDataSourceEntity(){}

    public static String  getInstance(){
        return datasource.get();
    }

    public static  void restore(){
        datasource.set(DEFAULT_SOURCE);
    }
    // DB_2018
    // DB_2019
    public static void set(String source){
        datasource.set(source);
    }

    public static void set(int year){
        datasource.set("DB_"+year);
    }

}
