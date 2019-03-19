package com.gupao.student.delegate.simple;

/**
 * Created with IntelliJ IDEA.
 * User: zhuochen
 * Date: 2019/3/14
 * Time: 21:57
 * Description:
 */
public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {

        System.out.println("我是员工B，我很擅长"+command+"工作");
    }
}
