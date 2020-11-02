package com.example.zhw.springsource.DesignPatterns.ChainofResponsibility;

public class Cilent {

    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setContext(handler2);
        //提交请求
        handler1.handleRequest("two");
    }

}
