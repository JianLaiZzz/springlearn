package com.example.zhw.springsource.thread;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * @author rd217
 */
public class CountDownLatchTest {


    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);


        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(1000);
                System.out.println("线程一执行");

                countDownLatch.countDown();

            }
        });


        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(1000);
                System.out.println("线程2执行");

                countDownLatch.countDown();

            }
        }).start();


        thread.start();



        try {

            System.out.println("等待");
            countDownLatch.await();
            System.out.println("主线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
