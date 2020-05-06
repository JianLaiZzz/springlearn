package com.example.zhw.springsource.bean;

/**
 * @author: zhw
 * @createDate: 2020/5/4
 */
public class DogFactory
{
	public Dog newInstance(String name, int age)
	{
		return new Dog(name, age);
	}
}
