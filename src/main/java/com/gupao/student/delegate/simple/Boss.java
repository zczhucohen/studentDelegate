package com.gupao.student.delegate.simple;

/**
 * Created with IntelliJ IDEA.
 * User: zhuochen
 * Date: 2019/3/14
 * Time: 21:53
 * Description:
 */
public class Boss {

    public void command(String command,Leader leader){
        leader.doing(command);
    }
}
