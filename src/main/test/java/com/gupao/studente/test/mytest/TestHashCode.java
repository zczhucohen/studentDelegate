package com.gupao.studente.test.mytest;

import com.gupao.student.pojo.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/28
 */
public class TestHashCode {

    public static void main(String[] args) {
        Map<Student, String> studentMap = new HashMap<>();
        Student student1 = new Student();
        student1.setClassName("三年二班");
        student1.setName("嬴政");
        student1.setSex(0);
        student1.setStudentNumber(1001);
        Student student2 = new Student();
        student2.setClassName("三年二班");
        student2.setName("嬴政");
        student2.setSex(0);
        student2.setStudentNumber(1001);

        System.out.println("student2hashCode:"+student2);
        System.out.println("student1hashCode:"+student1);
        studentMap.put(student1, "实验");
        studentMap.put(student2, "实验23");
        System.out.println(studentMap);
    }
}
