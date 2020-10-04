package com.example.zhw.springsource.netty.bio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author zhangwei1
 * @date 2020/6/5 15:06
 */
public class SubReqServer
{

	public static void main(String[] args)
	{
		int port = 8080;
		if (args != null && args.length > 0)
		{
			port = Integer.valueOf(args[0]);
		}

		new SubReqServer().bind(port);
	}

	public void bind(int port)
	{
		//配置服务端的nio线程组
		EventLoopGroup bossGroup = new NioEventLoopGroup();

		EventLoopGroup wokerGroup = new NioEventLoopGroup();

		try
		{
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, wokerGroup).channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 100).handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(new ChannelInitializer<SocketChannel>()
					{
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception
						{
							socketChannel.pipeline().addLast(new ObjectDecoder(1024 * 1024, ClassResolvers
									.weakCachingConcurrentResolver(this.getClass().getClassLoader())));

							socketChannel.pipeline().addLast(new ObjectEncoder());
							socketChannel.pipeline().addLast(new SubReqServerHandler());
						}
					});

			//绑定端口，同步等待成功
			ChannelFuture f = b.bind(port).sync();

			//等待服务器监听端口关闭
			f.channel().closeFuture().sync();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//优雅退出，释放线程池资源
			bossGroup.shutdownGracefully();
			wokerGroup.shutdownGracefully();
		}

	}

}