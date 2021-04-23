package com.example.zhw.springsource.producer;

import lombok.SneakyThrows;

public class Producer implements Runnable {


    private HamburgerFactory hamburgerFactory;

    public Producer(HamburgerFactory hamburgerFactory) {
        this.hamburgerFactory = hamburgerFactory;
    }

    @SneakyThrows
    @Override
    public void run() {

        while (true) {
            synchronized (hamburgerFactory) {
                Integer num = hamburgerFactory.getCurrentHamburgerList().size();

                if (num < HamburgerFactory.Max_NUM) {

                    //没汉堡了
                    System.out.println("当前汉堡数量:" + num);
                    hamburgerFactory.getCurrentHamburgerList().add(1);
                    hamburgerFactory.notifyAll();
                } else {
                    System.out.println("汉堡满了");
                    hamburgerFactory.wait();

                }


            }
        }

    }
}
