package com.gupao.student.prototype.simple;/**
 * Created by zhuochen on 2019/5/16.
 */

import java.util.List;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/16
 */
public class ConcretePrototypeA implements Prototype{

    private int age;

    private String name;

    private List hobbies;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }


    @Override
    public Prototype clone() {

        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(this.age);
        concretePrototypeA.setName(this.name);
        concretePrototypeA.setHobbies(this.hobbies);
        return concretePrototypeA;
    }
}
