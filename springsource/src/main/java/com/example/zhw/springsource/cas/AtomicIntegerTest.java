package com.example.zhw.springsource.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: zhw
 * @createDate: 2020/5/13
 */
public class AtomicIntegerTest
{
    public static void main(String args[])
    {
        int temvalue = 0;

        AtomicInteger atomicInteger=new AtomicInteger(0);
        temvalue=atomicInteger.getAndSet(3);
        System.out.println("temvalue:" + temvalue + ";  i:" + atomicInteger);//temvalue:0;  i:3
        temvalue = atomicInteger.getAndIncrement();
        System.out.println("temvalue:" + temvalue + ";  i:" + atomicInteger);//temvalue:3;  i:4
        temvalue = atomicInteger.getAndAdd(5);
        System.out.println("temvalue:" + temvalue + ";  i:" + atomicInteger);//temvalue:4;  i:9




    }
}
