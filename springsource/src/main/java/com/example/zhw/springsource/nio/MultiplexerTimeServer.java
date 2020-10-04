package com.example.zhw.springsource.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: zhw
 * @createDate: 2020/6/2
 */
public class MultiplexerTimeServer implements Runnable
{

	private Selector selector;

	private ServerSocketChannel serverSocketChannel;

	private volatile boolean stop;

	public MultiplexerTimeServer(int port)
	{
		try
		{

			//打开多路复用器
			selector = Selector.open();
			//打开服务端通道
			serverSocketChannel = ServerSocketChannel.open();
			//配置是否阻塞
			serverSocketChannel.configureBlocking(false);
			//监听端口
			serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);

			//注册多路复用器
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

			System.out.println("The time server is start in port:" + port);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}

	}

	public void stop()
	{
		this.stop = true;
	}

	@Override
	public void run()
	{
		while (!stop)
		{
			try
			{
				selector.select(1000);

				//准备就绪的channel
				Set<SelectionKey> selectionKeySet = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeySet.iterator();
				SelectionKey selectionKey = null;
				while (iterator.hasNext())
				{
					selectionKey = iterator.next();
					iterator.remove();

					try
					{
						handleinput(selectionKey);
					}
					catch (Exception e)
					{
						if (selectionKey != null)
						{
							selectionKey.cancel();
							if (selectionKey.channel() != null)
							{
								selectionKey.channel().close();
							}
						}
					}

				}

			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		//多路复用器关闭，所有注册在上的channel 和pipe 都会自动关闭
		if (selector != null)
		{

			try
			{
				selector.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}

	}

	private void handleinput(SelectionKey selectionKey)
	{
		if (selectionKey.isValid())
		{

			//处理新接入的请求消息
			if (selectionKey.isAcceptable())
			{
				ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();

				SocketChannel sc = null;
				try
				{
					sc = ssc.accept();
					sc.configureBlocking(false);

					sc.register(selector, SelectionKey.OP_READ);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}

			}

			if (selectionKey.isReadable())
			{
				try
				{

					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

					ByteBuffer readBuffer = ByteBuffer.allocate(1024);

					int readBytes = socketChannel.read(readBuffer);
					if (readBytes > 0)
					{

						readBuffer.flip();
						byte[] bytes = new byte[readBuffer.remaining()];
						readBuffer.get(bytes);

						String body = new String(bytes, "UTF-8");

						System.out.println("the timeser recevie order:" + body);

						String currenTime = "QUERY CURRRNT TIEM".equalsIgnoreCase(body)
								? new Date().toString()
								: "bad order";
						dowrite(socketChannel, currenTime);
					}
					else if (readBytes < 0)
					{
						//对链路关闭
						selectionKey.cancel();
						socketChannel.close();
					}
					else
					{
						//读到零字节
					}
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}

			}
		}

	}

	private void dowrite(SocketChannel channel, String respose) throws IOException
	{
		if (respose != null && respose.trim().length() > 0)
		{
			byte[] bytes = respose.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);

			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);

		}

	}
}
