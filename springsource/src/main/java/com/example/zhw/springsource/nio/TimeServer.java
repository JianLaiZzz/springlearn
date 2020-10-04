package com.example.zhw.springsource.nio;

/**
 * @author: zhw
 * @createDate: 2020/6/2
 */
public class TimeServer
{
	public static void main(String args[])
	{
		int port = 8080;

		MultiplexerTimeServer server = new MultiplexerTimeServer(port);

		new Thread(server, "Nio-MultiplexerTimeServer-001").start();

	}
}
