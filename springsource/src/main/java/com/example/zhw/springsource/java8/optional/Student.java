package com.example.zhw.springsource.java8.optional;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangwei1
 * @date 2020/6/24 10:10
 */
@Data
public class Student implements Serializable {

    private String name;

    private Integer score;

    public Student(Student student, String name, Integer score) {
        this.name = name;
        this.score = score;
        System.out.println("Student " + name + "'s score is " + score);
    }


    public void setNameAndScore(String name, Integer score) {
        this.name = name;
        this.score = score;
        System.out.println("Student " + name + "'s score is " + score);
    }

    public static void main(String[] args) {
        /*lambda表达式的用法：
        TestInterface testInterface = (student, name, score) -> student.setNameAndScore(name, score);*/
        //类的任意对象的实例方法引用的用法:
        TestInterface testInterface = Student::setNameAndScore;
        TestInterface testInterface1 = Student::new;
        testInterface.set(new Student(), "DoubleBin", 100);

        List<String> strList = Arrays.asList(new String[]{"a", "c", "b"});

        strList.stream().sorted((s1, s2) -> s1.compareToIgnoreCase(s2)).forEach(s -> System.out.println(s));


        strList.stream().sorted(String::compareToIgnoreCase).forEach(System.out::print);


    }

    @FunctionalInterface
    interface TestInterface {
        // 注意：入参比Student类的setNameAndScore方法多1个Student对象，除第一个外其它入参类型一致
        public void set(Student d, String name, Integer score);
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}