package com.gupao.student.observer.myadvice;


import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: zhuochen
 * Date: 2019/3/19
 * Time: 20:58
 * Description:
 */
public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Gper gper = (Gper) o;
        Question question = (Question) arg;
        System.out.println("==========================");
        System.out.println(name+"老师，你好！" +
                "您收到了一个来自“"+gper.getName()+"”的提问，希望您解答，问题内容如下：" +
                question.getContent()+"\n" +
                "提问者："+question.getUsername());
    }
}
