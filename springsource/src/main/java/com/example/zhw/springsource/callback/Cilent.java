package com.example.zhw.springsource.callback;

public class Cilent {


    public static void main(String[] args) {


        ICaller caller = new Caller();


        caller.call(new CallBack() {
            @Override
            public void execute(ICaller caller) {


                System.out.println("调用我做点事");
                caller.callBack("事情做完了");
            }
        });


    }
}
