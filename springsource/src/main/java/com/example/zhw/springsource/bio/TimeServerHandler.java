package com.example.zhw.springsource.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author: zhw
 * @createDate: 2020/5/31
 */
public class TimeServerHandler implements Runnable
{

	private Socket socket;

	public TimeServerHandler(Socket socket)
	{
		this.socket = socket;
	}

	@Override
	public void run()
	{
		BufferedReader in = null;

		PrintWriter out = null;

		try
		{
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			out = new PrintWriter(this.socket.getOutputStream(), true);

			String currenTime = null;
			String body = null;

			while (true)
			{
				body = in.readLine();

				if (body == null)
				{
					break;
				}
				System.out.println("the timeser recevie order:" + body);

				currenTime = "QUERY CURRRNT TIEM".equalsIgnoreCase(body) ? new Date().toString()
						: "bad order";

				out.println(currenTime);
				//				System.out.println(new Date().toString());

			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (in != null)
			{
				try
				{
					in.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

			if (out != null)
			{
				out.close();
			}

			if (socket != null)
			{
				try
				{
					socket.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

	}
}
