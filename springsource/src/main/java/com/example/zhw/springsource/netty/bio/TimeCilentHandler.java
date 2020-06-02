package com.example.zhw.springsource.netty.bio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * @author zhangwei1
 * @date 2020/6/2 15:07
 */
public class TimeCilentHandler extends ChannelHandlerAdapter {
    Class clazz;
    private static final Logger LOGGER = Logger.getLogger(TimeCilentHandler.class.getName());

    private final ByteBuf firstMessage;

    public TimeCilentHandler() {

        byte[] req = "QUERY TIME ORDER".getBytes();
        this.firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;

        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "utf-8");
        System.out.println("now is:" + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.warning("exceptionmessage" + cause.getMessage());
        ctx.close();
    }
}