package com.example.zhw.springsource.java8;

public class Cilent {

    public static void main(String[] args) {

        TestService testService = (int a, int b) -> {
            return a + b;
        };

        TestService testService1 = (a, b) -> a * b;

        System.out.println(testService1.sum(3, 2));
        System.out.println(testService.sum(1, 2));

        BService service = b -> {
            System.out.println("testB" + b);
        };
        service.sum("5");
        BService bService = b -> System.out.println("hhh");
        bService.sum("1");

    }
}
