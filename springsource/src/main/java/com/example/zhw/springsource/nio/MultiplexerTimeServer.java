package com.example.zhw.springsource.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
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
			selector = Selector.open();

			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);

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

				Set<SelectionKey> selectionKeySet = selector.selectedKeys();

				Iterator<SelectionKey> iterator = selectionKeySet.iterator();

				SelectionKey selectionKey = null;
				while (iterator.hasNext())
				{
					selectionKey = iterator.next();
					iterator.remove();

				}

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

			}
		}

	}

	private void dowrite(SocketChannel channel, String respose)
	{
		if (respose != null && respose.trim().length() > 0)
		{

		}

	}
}
