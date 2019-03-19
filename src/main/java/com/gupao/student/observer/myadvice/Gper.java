package com.gupao.student.observer.myadvice;

import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: zhuochen
 * Date: 2019/3/19
 * Time: 20:38
 * Description:JDK提供的一种观察者模式 被观察者
 */
public class Gper extends Observable {

    private String name ="Gper生态圈";
    private static Gper gper = null;

    public Gper() {
    }

    public static Gper getGperInstance(){
        if(gper == null){
            gper = new Gper();
        }
        return gper;
    }

    public String getName() {
        return name;
    }
    public void publicQuestion(Question question){
        System.out.println(question.getUsername()+"在"+this.name+"上提交了一个问题");
        setChanged();
        notifyObservers(question);
    }

}
