package com.example.zhw.springsource.callback;

public class Caller implements ICaller {


    @Override
    public void call(CallBack callBack) {


        System.out.println("调用者");
        callBack.execute(this);
    }


    @Override
    public void callBack(String message) {
        System.out.println("回调函数："+message);
    }

}
