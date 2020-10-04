package com.example.zhw.springsource.netty.bio;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author zhangwei1
 * @date 2020/6/5 15:12
 */
public class SubReqServerHandler extends ChannelHandlerAdapter
{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{

		SubscribeReq subscribeReq = (SubscribeReq) msg;

		if ("zhangwei".equalsIgnoreCase(subscribeReq.getUserName()))
		{
			System.out.println("receive req:" + subscribeReq.toString());

			ctx.writeAndFlush(resq(subscribeReq.getSubReqId()));

		}
	}

	private SubscribeResq resq(int subReqId)
	{

		SubscribeResq subscribeResq = new SubscribeResq();
		subscribeResq.setSubReqId(subReqId);
		subscribeResq.setResqCode(0);
		subscribeResq.setDesc("Netty book order succeed ,3 day  later ,sent  to the designated address");

		return subscribeResq;
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		cause.printStackTrace();
		ctx.close();
	}
}