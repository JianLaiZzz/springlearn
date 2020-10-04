package com.example.zhw.springsource.inner;

/**
 * @author zhangwei1
 * @date 2020/6/28 18:59
 */
public class TestInner
{

	private Integer age;

	private void say()
	{

	}

	public interface Fly
	{

		void say();
	}

	private class InnerA implements Fly
	{

		@Override
		public void say()
		{

			TestInner.this.say();
			int age = TestInner.this.age;

		}
	}

	public static class InnerB
	{

		public void eat()
		{

		}
	}

	public static void main(String[] args)
	{

		TestInner testInner = new TestInner();

		Fly fly = testInner.new InnerA();

		TestInner.InnerB innerB = new TestInner.InnerB();

	}

}