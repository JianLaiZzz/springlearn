package com.example.zhw.springsource.springdesign.proxy.staticproxy;

/**
 * @author zhangwei
 * @date 2020/11/5 15:25
 */
public class Fater implements Person {


    private Person person;


    public Fater(Person person) {
        this.person = person;

    }


    @Override
    public void findLove() {

        System.out.println("提前增强");

        person.findLove();
        System.out.println("后面增强");

    }
}
