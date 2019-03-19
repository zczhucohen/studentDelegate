package com.gupao.student.delegate.simple;

/**
 * Created with IntelliJ IDEA.
 * User: zhuochen
 * Date: 2019/3/14
 * Time: 21:51
 * Description: 员工要做的事情
 */
public interface IEmployee {
    /**
     * 需要做的命令
     * @param command 命令
     */
    public void doing(String command);
}
