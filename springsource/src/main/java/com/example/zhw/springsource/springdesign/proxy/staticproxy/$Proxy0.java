package com.example.zhw.springsource.springdesign.proxy.staticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author Administrator
 */
public final class $Proxy0 extends Proxy implements Person
{
	private static Method m1;
	private static Method m3;
	private static Method m2;
	private static Method m0;

	public $Proxy0(final InvocationHandler invocationHandler)
	{
		super(invocationHandler);
	}

	@Override
	public final void findLove()
	{
		try
		{
			super.h.invoke(this, $Proxy0.m3, null);
		}
		catch (Throwable t)
		{
			throw new UndeclaredThrowableException(t);
		}
	}

	@Override
	public final boolean equals(final Object o)
	{
		try
		{
			return (boolean) super.h.invoke(this, $Proxy0.m1, new Object[] { o });
		}
		catch (Throwable t)
		{
			throw new UndeclaredThrowableException(t);
		}
	}

	@Override
	public final String toString()
	{
		try
		{
			return (String) super.h.invoke(this, $Proxy0.m2, null);
		}
		catch (Throwable t)
		{
			throw new UndeclaredThrowableException(t);
		}
	}

	@Override
	public final int hashCode()
	{
		try
		{
			return (int) super.h.invoke(this, $Proxy0.m0, null);
		}
		catch (Throwable t)
		{
			throw new UndeclaredThrowableException(t);
		}
	}

	static
	{
		try
		{
			$Proxy0.m1 = Class.forName("java.lang.Object").getMethod("equals",
					Class.forName("java.lang.Object"));
			$Proxy0.m3 = Class
					.forName("com.example.zhw.springsource.springdesign.proxy.staticproxy.Person")
					.getMethod("findLove", (Class<?>[]) new Class[0]);
			$Proxy0.m2 = Class.forName("java.lang.Object").getMethod("toString",
					(Class<?>[]) new Class[0]);
			$Proxy0.m0 = Class.forName("java.lang.Object").getMethod("hashCode",
					(Class<?>[]) new Class[0]);
		}
		catch (NoSuchMethodException ex)
		{
			throw new NoSuchMethodError(ex.getMessage());
		}
		catch (ClassNotFoundException ex2)
		{
			throw new NoClassDefFoundError(ex2.getMessage());
		}
	}
}
