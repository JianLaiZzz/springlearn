package com.example.zhw.springsource.springdesign.clone;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangwei
 * @date 2020/11/1 21:44
 **/

@Data
@NoArgsConstructor
public class Student implements Cloneable
{

	private int age;
	private String name;

	public Student(int age, String name)
	{
		this.age = age;
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException
	{
		Student student1 = new Student(20, "张三");
		Student student2 = (Student) student1.clone();

		// 注意修改student2的age值 但是没有影响 student1的值
		student2.setAge(22);
		//		student2.setName("lisi");

		System.out.println(System.identityHashCode(student1.getName()));
		System.out.println(System.identityHashCode(student2.getName()));
		System.out.println("student1：" + student1.getName() + "-->" + student1.getAge());
		System.out.println("student2：" + student2.getName() + "-->" + student2.getAge());

	}
}
