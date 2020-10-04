package com.example.zhw.springsource.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangwei1
 * @date 2020/6/3 14:36
 */
public class TimeCilentHandle implements Runnable
{

	private String host;

	private int port;

	private Selector selector;

	private SocketChannel socketChannel;

	private volatile boolean stop;

	public TimeCilentHandle(String host, int port)
	{
		this.host = host == null ? "127.0.0.1" : host;
		this.port = port;

		try
		{
			selector = Selector.open();

			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);

		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}

	}

	@Override
	public void run()
	{

		try
		{
			doConnect();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}

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
				System.exit(1);
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

	private void handleinput(SelectionKey selectionKey) throws IOException
	{
		if (selectionKey.isValid())
		{

			SocketChannel sc = (SocketChannel) selectionKey.channel();
			if (selectionKey.isConnectable())
			{
				if (sc.finishConnect())
				{

					sc.register(selector, SelectionKey.OP_READ);
					doWrite(sc);
				}
				else
				{
					//连接失败，进程退出
					System.exit(1);
				}
			}

			if (selectionKey.isReadable())
			{
				try
				{

					ByteBuffer readBuffer = ByteBuffer.allocate(1024);

					int readBytes = sc.read(readBuffer);
					if (readBytes > 0)
					{

						readBuffer.flip();
						byte[] bytes = new byte[readBuffer.remaining()];
						readBuffer.get(bytes);

						String body = new String(bytes, "UTF-8");

						System.out.println("now is " + body);
						this.stop = true;

					}
					else if (readBytes < 0)
					{
						//对链路关闭
						selectionKey.cancel();
						sc.close();
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

	private void doConnect() throws IOException
	{
		//如果直接连接成功，则注册到多路复用器上，发送请求消息，读应答
		if (socketChannel.connect(new InetSocketAddress(host, port)))
		{

			socketChannel.register(selector, SelectionKey.OP_READ);
		}
		else
		{
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
		}
	}

	private void doWrite(SocketChannel sc) throws IOException
	{

		byte[] req = "QUERY CURRRNT TIEM".getBytes();

		ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
		writeBuffer.put(req);
		writeBuffer.flip();
		sc.write(writeBuffer);

		if (!writeBuffer.hasRemaining())
		{
			System.out.println("Send order 2 server success");
		}

	}
}