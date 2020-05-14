package com.example.zhw.springsource.cas;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author: zhw
 * @createDate: 2020/5/13
 */
public class AtomicIntegerFieldUpdaterTest
{
	public static void main(String[] args)
	{
		AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

		User user = new User("Java", 22);
		System.out.println(a.getAndIncrement(user));// 22
		System.out.println(a.get(user));// 23
	}

	static class User
	{
		private String name;
		public volatile int age;

		public User(String name, int age)
		{
			super();
			this.name = name;
			this.age = age;
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public int getAge()
		{
			return age;
		}

		public void setAge(int age)
		{
			this.age = age;
		}

	}
}
