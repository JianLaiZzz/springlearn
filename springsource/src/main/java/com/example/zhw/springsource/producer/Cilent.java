package com.example.zhw.springsource.producer;

public class Cilent {

    public static void main(String[] args) {

        HamburgerFactory hamburgerFactory = new HamburgerFactory();


        Producer producer = new Producer(hamburgerFactory);

        Consumer consumer = new Consumer(hamburgerFactory);

        Thread producer1 = new Thread(producer);
        Thread producer2 = new Thread(producer);
        Thread producer3 = new Thread(producer);


        Thread consumer1 = new Thread(consumer);
        Thread consumer2 = new Thread(consumer);
        Thread consumer3 = new Thread(consumer);
        Thread consumer4 = new Thread(consumer);
        Thread consumer5 = new Thread(consumer);

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();


        producer1.start();
        producer2.start();
        producer3.start();


    }
}
