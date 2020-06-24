package com.example.zhw.springsource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhw
 * @createDate: 2020/6/13
 */
public class Basic
{

	public static void main(String args[])
	{

		float a = 1 - 0.9f;
		float b = 0.9f - 0.8f;

//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(a == b);
//
//		String[] arr = new String[5];
//		arr[0] = "a";
//		arr[1] = "b";
//		arr[2] = "c";
//		arr[3] = "d";
//		arr[4] = "e";
//
//		String[] s = new String[] { "hello", "word" };
//
//		List<String> list = Arrays.asList(s);
//
//
//		s[0] = "zhangw";
//
//		System.out.println(list.toString());
//		list.forEach(s1 ->
//		{
//			System.out.println(s1);
//		});
//



		List<String> stringList = new ArrayList<>();

		stringList.add("zhw");

		String[] strings = new String[stringList.size()];
		stringList.toArray(strings);
		for (int i = 0; i < strings.length; i++)
		{
			System.out.print(strings[i]);
		}

	}
}
