package com.example.zhw.springsource.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamTest {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        list.stream().filter(t -> t > 5).forEach(System.out::println);

        Optional<Integer> optional = list.stream().filter(t -> t > 10).findFirst();


        if (optional.isPresent()) {
            optional.get();
        }


    }

}
