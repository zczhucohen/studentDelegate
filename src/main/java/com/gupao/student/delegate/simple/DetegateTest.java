package com.gupao.student.delegate.simple;

/**
 * Created with IntelliJ IDEA.
 * User: zhuochen
 * Date: 2019/3/14
 * Time: 22:12
 * Description:
 */
public class DetegateTest {

    public static void main(String[] args) {
        new Boss().command("接口", new Leader());
    }
}
