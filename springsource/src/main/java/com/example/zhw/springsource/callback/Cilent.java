package com.example.zhw.springsource.callback;

public class Cilent {


    public static void main(String[] args) throws Exception {


        ICaller caller = new Caller();


        caller.call(new CallBack() {
            @Override
            public void execute(ICaller caller) throws Exception {


                System.out.println("调用我做点事");
                caller.callBack("事情做完了");
            }
        });


    }
}
