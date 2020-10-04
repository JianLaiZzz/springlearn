package com.example.zhw.springsource.netty.bio;

import lombok.Data;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * @author zhangwei1
 * @date 2020/6/5 11:17
 */
@Data
public class UserInfo implements Serializable
{

	private String userName;

	private int userId;

	public UserInfo buildUserName(String userName)
	{
		this.userName = userName;
		return this;
	}

	public UserInfo buildUserId(int userId)
	{
		this.userId = userId;
		return this;
	}

	public byte[] codeC()
	{
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		byte[] value = this.userName.getBytes();

		buffer.putInt(value.length);
		buffer.put(value);

		buffer.putInt(this.userId);
		buffer.flip();

		value = null;

		byte[] result = new byte[buffer.remaining()];
		buffer.get(result);
		return result;

	}

}