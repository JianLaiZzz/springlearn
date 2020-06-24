package com.example.zhw.springsource.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangwei1
 * @date 2020/6/24 15:02
 */
public class StreamTest {
    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1, 2, -1, -3, 5, 9);

        long count = list.parallelStream().filter(i -> i > 0).count();

        //System.out.println("Positive count: " + count);

        //list.stream().forEach(s -> System.out.println(s));

        list.stream().map(s -> Math.abs(s)).forEach(s -> System.out.println(s));

        List<String> list1 = Arrays.asList("1 2", "3 4", "5 6");

        list1.stream().flatMap(item -> Arrays.stream(item.split(" "))).forEach(System.out::print);


        list1.stream().flatMap(item -> Arrays.stream(item.split(" "))).collect(Collectors.toList());


    }
}