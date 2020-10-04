package com.example.zhw.springsource.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class $Proxy11 extends Proxy implements UserService
{
	/**
	 * Constructs a new {@code Proxy} instance from a subclass
	 * (typically, a dynamic proxy class) with the specified value
	 * for its invocation handler.
	 *
	 * @param h
	 *            the invocation handler for this proxy instance
	 * @throws NullPointerException
	 *             if the given invocation handler, {@code h},
	 *             is {@code null}.
	 */
	protected $Proxy11(InvocationHandler h)
	{
		super(h);
	}

	/**
	 * 目标方法
	 */
	@Override
	public void add()
	{

	}

	//	private static Method m3;
	//
	//	public $Proxy11(InvocationHandler paramInvocationHandler)throws{
	//        super(paramInvocationHandler);
	//    }
	//
	//	@Override
	//	public final void add()throws{
	//        try
	//        {
	//            this.h.invoke(this, m3, null);
	//            return;
	//        }
	//        catch (Error|RuntimeException localError)
	//        {
	//            throw localError;
	//        }
	//        catch (Throwable localThrowable)
	//        {
	//            throw new UndeclaredThrowableException(localThrowable);
	//        }
	//    }
	//
	//	static
	//	{
	//		try
	//		{
	//
	//			m3 = Class.forName("com.example.zhw.springsource.dynamic.proxy.UserService").getMethod("add",
	//					new Class[0]);
	//
	//		}
	//		catch (NoSuchMethodException localNoSuchMethodException)
	//		{
	//			throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
	//		}
	//		catch (ClassNotFoundException localClassNotFoundException)
	//		{
	//			throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
	//		}
	//	}
}