package com.example.zhw.springsource.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class SemaphoreExample {


    private static int threadNums = 500;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(300);

        Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < threadNums; i++) {
            int finalI = i;

            service.execute(
                    () -> {
                        try {
                            if (finalI == 7) {
                                System.out.println(7);
                            }
                            semaphore.acquire(5);
                            test(finalI);
                            semaphore.release(5);


                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
        }


        service.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNums) throws InterruptedException {

        Thread.sleep(1000);
        System.out.println("threadNum:" + threadNums);
        Thread.sleep(1000);
    }
}
