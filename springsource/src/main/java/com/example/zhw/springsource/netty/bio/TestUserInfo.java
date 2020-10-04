package com.example.zhw.springsource.netty.bio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author zhangwei1
 * @date 2020/6/5 11:54
 */
public class TestUserInfo
{
	public static void main(String[] args) throws IOException
	{
		UserInfo userInfo = new UserInfo();

		userInfo.buildUserId(100).buildUserName("Welcome to Netty");

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		ObjectOutputStream os = new ObjectOutputStream(bos);

		os.writeObject(userInfo);
		os.flush();
		os.close();

		byte[] b = bos.toByteArray();

		System.out.println("The jdk Serializable length is :" + b.length);
		bos.close();

		System.out.println("-------------------------------------------------");

		System.out.println("The byte array Serializable length is :" + userInfo.codeC().length);

	}
}