package com.example.zhw.springsource.java8;

@FunctionalInterface
public interface TestService {

    int sum(int a, int b);

    default void getStr() {
        System.out.println("heheheh");
    }

    default void getStr2() {
        System.out.println("heheheh");
    }

    static void getName(String name) {

        System.out.println(name);
    }


}
