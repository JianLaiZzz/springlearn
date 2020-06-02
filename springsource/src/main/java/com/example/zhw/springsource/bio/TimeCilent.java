package com.example.zhw.springsource.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author: zhw
 * @createDate: 2020/5/31
 */
public class TimeCilent
{
	public static void main(String args[])
	{
		Socket socket = null;

		BufferedReader in = null;

		PrintWriter out = null;

		try
		{
			socket = new Socket("127.0.0.1", 8080);

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			out = new PrintWriter(socket.getOutputStream(), true);

			out.println("QUERY CURRRNT TIEM");

			System.out.println("send succeed");

			String res = in.readLine();
			System.out.println("now is" + res);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{

			try
			{
				in.close();
				out.close();
				socket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}

	}
}
