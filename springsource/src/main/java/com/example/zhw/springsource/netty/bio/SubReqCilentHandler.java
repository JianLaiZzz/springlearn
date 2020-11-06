package com.example.zhw.springsource.netty.bio;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author zhangwei1
 * @date 2020/6/5 15:25
 */
public class SubReqCilentHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReq subReq(int i) {

        SubscribeReq subscribeReq = new SubscribeReq();
        subscribeReq.setUserName("zhangwei");
        subscribeReq.setAddress("科陆电子");
        subscribeReq.setProductName("Netty权威指南");
        subscribeReq.setIphoneNumber("12241242414");
        subscribeReq.setSubReqId(i);

        return subscribeReq;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive  server respose" + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}