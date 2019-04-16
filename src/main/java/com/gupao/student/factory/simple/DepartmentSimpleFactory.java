package com.gupao.student.factory.simple;/**
 * Created by zhuochen on 2019/4/16.
 */

import com.gupao.student.factory.Department;
import com.gupao.student.factory.ResearchDepartment;
import com.gupao.student.factory.SellDepartment;

/**
 *  简单工作模式
 * @author zhuochen
 * @comment
 * @date 2019/4/16
 */
public class DepartmentSimpleFactory {

    /*public Department create(String name){
        if("research".equals(name)){
            return new ResearchDepartment();
        }else if("sell".equals(name)){
            return new SellDepartment();
        }else{
            return null;
        }
    }
    *//**
     * 通过反射得到
     * @parameter [ClassName]
     * @return
     * @author zhuochen
     * @date 2019/4/16
     *//*
    public Department createNew(String className){

        if(!(null == className || "".equals(className))){
            try {
                return (Department) Class.forName(className).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }*/

    public Department createInstance(Class<? extends Department> clazz){
        try {
            if(null != clazz){
                return clazz.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
