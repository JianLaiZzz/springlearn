package com.example.zhw.springsource.producer;

import lombok.SneakyThrows;

public class Consumer implements Runnable {

    private HamburgerFactory hamburgerFactory;

    public Consumer(HamburgerFactory hamburgerFactory) {
        this.hamburgerFactory = hamburgerFactory;
    }

    @SneakyThrows
    @Override
    public void run() {

        while (true) {

            synchronized (hamburgerFactory) {
                Integer num = hamburgerFactory.getCurrentHamburgerList().size();

                if (num <= 0) {

                    //没汉堡了
                    System.out.println("没汉堡了");
                    hamburgerFactory.wait();
                } else {
                    //吃了一个汉堡
                    hamburgerFactory.getCurrentHamburgerList().remove(0);
                    hamburgerFactory.notifyAll();

                }


            }
        }

    }
}
