package com.gupao.student.pojo;

import java.util.Objects;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/28
 */
public class Student {
    // 学号
    private int studentNumber;
    // 姓名
    private String name;
    // 班级名字
    private String className;

    private int sex; // 性别，1女，0男

    public Student() {
    }

    public Student(int studentNumber, String name, String className, int sex) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.className = className;
        this.sex = sex;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber &&
                sex == student.sex &&
                name.equals(student.name) &&
                className.equals(student.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNumber, name, className, sex);
    }

    /*@Override
    public String toString() {
        return "Student{" +
                "studentNumber=" + studentNumber +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", sex=" + sex +
                '}';
    }*/
}
