package com.gupao.student.prototype.simple;/**
 * Created by zhuochen on 2019/5/16.
 */

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/16
 */
public class Client {

    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }
    public Prototype startClone(Prototype concretePrototypr){
        return (Prototype)concretePrototypr.clone();
    }
}
