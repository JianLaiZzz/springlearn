package com.example.zhw.springsource.java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author zhangwei1
 * @date 2020/6/24 10:11
 */
public class OptionalTest<U>
{

	public <T> T get(Function<? super T, ? extends U> mapper)
	{

		return null;
	}

	public static String getGender(Student student)
	{

		return Optional.ofNullable(student).map(u -> u.getName()).orElse("Unkown");
	}

	private static void printNmae(Student student)
	{
		Optional.ofNullable(student).ifPresent(u -> System.out.println(u.getName()));
	}

	private static void filterNmae(Student student)
	{
		Optional.ofNullable(student).filter(u -> u.getName().equals("zhw"))
				.ifPresent(u -> System.out.println(u.getName()));
	}

	public static void filter(List<Integer> numbers, Predicate<Integer> condition)
	{

		for (Integer num : numbers)
		{
			if (condition.test(num))
			{
				System.out.println("Eligible number: " + num);
			}
		}
	}

	public static void main(String[] args)
	{
		System.out.println(getGender(new Student()));

		//printNmae(new Student("zhw"));

		filterNmae(new Student("zhw1"));

		new Thread(() -> System.out.println("heh")).start();

		List list = Arrays.asList(1, 2);

		list.forEach(s -> System.out.println(s));

		filter(list, o -> o > 0);

	}

}