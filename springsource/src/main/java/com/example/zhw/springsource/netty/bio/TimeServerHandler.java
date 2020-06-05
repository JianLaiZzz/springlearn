package com.example.zhw.springsource.netty.bio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * @author zhangwei1
 * @date 2020/6/2 14:42
 */
public class TimeServerHandler extends ChannelHandlerAdapter
{

	private int counter;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{

		String body = (String) msg;

		System.out.println("the time server receive order :" + body + ";the counter is:" + ++counter);
		String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date().toString()
				: "bad order";

		currentTime = currentTime + System.getProperty("line.separator");

		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		ctx.write(resp);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception
	{
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		ctx.close();
	}
}