package com.example.zhw.springsource.event;

/**
 * @author: zhw
 * @createDate: 2020/5/26
 */
public class Test
{
	public static void main(String args[])
	{
		ApplicationContext applicationContext = new ApplicationContext();

		applicationContext.add(event ->
		{
			Object source = event.getSource();

			if (source instanceof Integer)
			{
				int now = (int) source;
				System.out.println("检测到事件源为整型：事件源变为" + now);
			}
		});

		/**
		 * 添加监听事件源为字符串类型的监听器
		 */
		applicationContext.add(event ->
		{
			Object source = event.getSource();
			if (source instanceof String)
			{
				String now = (String) source;
				System.out.println("检测到事件源为字符串类型：事件源变为" + now);
			}
		});

		applicationContext.publishEvent(new ApplicationEvent("hello"));

	}
}
