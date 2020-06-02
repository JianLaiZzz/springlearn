package com.example.zhw.springsource.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: zhw
 * @createDate: 2020/5/29
 */
public class TimeServer
{
	public static void main(String args[])
	{
		int port = 8080;

		if (args != null && args.length > 0)
		{

			port = Integer.valueOf(args[0]);
		}
		ServerSocket serverSocket = null;

		try
		{
			serverSocket = new ServerSocket(port);
			System.out.println("start port" + port);

			Socket socket = null;
			TimeServerHandlerExecutePool pool = new TimeServerHandlerExecutePool(50, 1000);
			while (true)
			{
				socket = serverSocket.accept();

				//new Thread(new TimeServerHandler(socket)).start();
				pool.execute(new TimeServerHandler(socket));

			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (serverSocket != null)
			{

				System.out.println("the timer is closed");
				try
				{
					serverSocket.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

		}

	}
}
