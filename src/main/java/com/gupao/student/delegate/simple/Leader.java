package com.gupao.student.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhuochen
 * Date: 2019/3/14
 * Time: 21:55
 * Description: 委派模式 - 老板不直接与员工接触，是经理分发给个员工下的任务。
 */
public class Leader {

    // 了解自己的员工擅长的事情，才能更好的分发任务
    private Map<String,IEmployee> register = new HashMap<String, IEmployee>();

    public Leader(){
        register.put("接口", new EmployeeA());
        register.put("架构", new EmployeeB());
    }


    public void doing(String command){
        register.get(command).doing(command);
    }
}
