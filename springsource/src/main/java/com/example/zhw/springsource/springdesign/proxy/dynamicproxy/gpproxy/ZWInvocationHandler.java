package com.example.zhw.springsource.springdesign.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

public interface ZWInvocationHandler
{

	Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
