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
public class TimeCilentHandler extends ChannelHandlerAdapter
{

	private static final Logger LOGGER = Logger.getLogger(TimeCilentHandler.class.getName());

	//    private final ByteBuf firstMessage;

	private int counter;

	private byte[] req;

	public TimeCilentHandler()
	{

		req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception
	{
		ByteBuf firstMessage = null;
		for (int i = 0; i < 100; i++)
		{
			firstMessage = Unpooled.buffer(req.length);
			firstMessage.writeBytes(req);
			ctx.writeAndFlush(firstMessage);
		}

	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		//        ByteBuf buf = (ByteBuf) msg;
		//
		//        byte[] req = new byte[buf.readableBytes()];
		//        buf.readBytes(req);

		String body = (String) msg;
		System.out.println("now is:" + body + ";the counter is:" + ++counter);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		LOGGER.warning("exceptionmessage" + cause.getMessage());
		ctx.close();
	}
}