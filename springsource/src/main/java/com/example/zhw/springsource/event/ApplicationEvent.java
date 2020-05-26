package com.example.zhw.springsource.event;

import java.util.EventObject;

/**
 * @author: zhw
 * @createDate: 2020/5/26
 */
public class ApplicationEvent extends EventObject
{
	/**
	 * Constructs a prototypical Event.
	 *
	 * @param source
	 *            The object on which the Event initially occurred.
	 * @throws IllegalArgumentException
	 *             if source is null.
	 */
	public ApplicationEvent(Object source)
	{
		super(source);
	}
}
