package com.example.zhw.springsource.springdesign.proxy.staticproxy;

/**
 * @author zhangwei
 * @date 2020/11/5 15:32
 */
public class Cilent {

    public static void main(String[] args) {

        Person person = new Fater(new Son());

        person.findLove();


    }
}
