package com.gupao.student.prototype.simple;/**
 * Created by zhuochen on 2019/5/16.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/16
 */
public class PrototypeTest {

    public static void main(String[] args) {
        // 创建一个具体的需要克隆的对象
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        // 填充属性，方便测试
        concretePrototype.setAge(18);
        concretePrototype.setName("prototype");
        List hoobies = new ArrayList<String>();
        hoobies.add("测试内同");
        concretePrototype.setHobbies(hoobies);
        System.out.println(concretePrototype);

        // 创建Client对象，准备开始克隆
        Client client = new Client(concretePrototype);
        ConcretePrototypeA concretePrototypeClone = (ConcretePrototypeA)client.startClone(concretePrototype);
        System.out.println(concretePrototypeClone);

        System.out.println("克隆对象中的引用类型地址："+concretePrototypeClone.getHobbies());
        System.out.println("原对象中的引用类型地址值："+concretePrototype.getHobbies());
        System.out.println("对象地址比较："+(concretePrototype.getHobbies() == concretePrototypeClone.getHobbies()));

    }
}
