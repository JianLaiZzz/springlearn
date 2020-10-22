package com.example.zhw.springsource.DesignPatterns.ChainofResponsibility;

public abstract class Handler {


    private Handler context;


    public Handler getContext() {
        return context;
    }

    public void setContext(Handler context) {
        this.context = context;
    }


    public abstract void handleRequest(String request);
}
