package com.example.zhw.springsource.nio;

/**
 * @author zhangwei1
 * @date 2020/6/3 16:27
 */
public class TimeCilent {
    public static void main(String[] args) {
        int port = 8080;

        new Thread(new TimeCilentHandle(null, port), "timeCilent-001").start();
    }
}