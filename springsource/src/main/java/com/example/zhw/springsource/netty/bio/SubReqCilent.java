package com.example.zhw.springsource.netty.bio;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @author zhangwei1
 * @date 2020/6/5 15:24
 */
public class SubReqCilent
{
	public static void main(String[] args)
	{
		int port = 8080;
		new SubReqCilent().connect(port, "127.0.0.1");
	}

	public void connect(int port, String host)
	{

		EventLoopGroup group = new NioEventLoopGroup();

		try
		{
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>()
					{
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception
						{

							socketChannel.pipeline().addLast(new ObjectDecoder(1024 * 1024,
									ClassResolvers.cacheDisabled(this.getClass().getClassLoader())));
							socketChannel.pipeline().addLast(new ObjectEncoder());
							socketChannel.pipeline().addLast(new SubReqCilentHandler());
						}
					});
			//发起连接操作
			ChannelFuture f = b.connect(host, port).sync();

			//等待客户端链路关闭
			f.channel().closeFuture().sync();

		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			group.shutdownGracefully();
		}
	}
}