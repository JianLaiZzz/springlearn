package com.example.zhw.springsource.spi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author: zhw
 * @createDate: 2020/5/6
 */
public class DriverManagerSpl
{
	static String url = "jdbc:mysql://120.78.132.139:3306/book?useUnicode=true&characterEncoding=utf8";
	static String user = "root";
	static String password = "123456";

	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		new HashMap();

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, user, password);

	}
}
