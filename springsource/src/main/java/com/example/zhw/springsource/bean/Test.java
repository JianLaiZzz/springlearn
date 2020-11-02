package com.example.zhw.springsource.bean;

/**
 * @author zhangwei
 * @date 2020/10/28 21:53
 **/
public class Test
{
	public static void main(String[] args)
	{
		String name = "Scott";
		int age = 5;
		User user = new User();
		user.setName(name);
		user.setAge(age);
		System.out.println("before change user = " + user);

		change(user, name, age);
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("after change user = " + user);
	}

	public static void change(User user, String name, int age)
	{
		name = "Tom";
		age = 20;
		user.setName(name);
		user.setAge(age);
	}

	static class User
	{
		private String name;
		private int age;

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

		@Override
		public String toString()
		{
			return "{name : " + name + ", age : " + age + "}";
		}
	}

}
