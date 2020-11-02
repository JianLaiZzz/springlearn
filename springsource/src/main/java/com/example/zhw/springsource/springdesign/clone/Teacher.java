package com.example.zhw.springsource.springdesign.clone;

import lombok.Data;
import lombok.ToString;

/**
 * @author zhangwei
 * @date 2020/11/2 22:21
 **/

@Data
@ToString
public class Teacher implements Cloneable
{

	private String name;

	private Student student;

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		//		return super.clone();
		Teacher teacher = (Teacher) super.clone();
		Student student = (Student) teacher.getStudent().clone();
		teacher.setStudent(student);

		return teacher;

	}

	public static void main(String[] args) throws CloneNotSupportedException
	{

		Student s1 = new Student();
		s1.setAge(20);
		s1.setName("张三");

		Teacher teacher1 = new Teacher();
		teacher1.setName("小赵老师");
		teacher1.setStudent(s1);

		Teacher teacher2 = (Teacher) teacher1.clone();
		Student s2 = teacher2.getStudent();

		s2.setName("李四");
		s2.setAge(30);
		System.out.println("teacher1:" + teacher1);
		System.out.println("teacher2:" + teacher2);

	}
}
