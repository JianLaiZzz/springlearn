package com.example.zhw.springsource.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: zhw
 * @createDate: 2020/5/13
 */
public class AtomicReferenceTest
{
	public static void main(String args[])
	{
		AtomicReference<Person> atomicReference = new AtomicReference<>();

		Person person = new Person(18, "zhw");
		atomicReference.set(person);

		Person person1 = new Person(18, "lizhi");
		atomicReference.compareAndSet(person, person1);

		System.out.println(atomicReference.get().getName());

	}

	protected static class Person
	{
		private int age;

		private String name;

		public int getAge()
		{
			return age;
		}

		public void setAge(int age)
		{
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

		public Person(int age, String name)
		{
			this.age = age;
			this.name = name;
		}
	}
}
