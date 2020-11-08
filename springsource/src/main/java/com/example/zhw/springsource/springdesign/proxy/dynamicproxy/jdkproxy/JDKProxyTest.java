package com.example.zhw.springsource.springdesign.proxy.dynamicproxy.jdkproxy;

import java.io.FileOutputStream;

import com.example.zhw.springsource.springdesign.proxy.staticproxy.Person;

import lombok.SneakyThrows;
import sun.misc.ProxyGenerator;

/**
 * @author zhangwei
 * @date 2020/11/8 20:00
 **/
public class JDKProxyTest
{

	@SneakyThrows
	public static void main(String[] args) throws NoSuchMethodException
	{

		Person person = (Person) new JDKMeipo().getInstance(new Girl());

		person.findLove();

		byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[] { Person.class });
		FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
		os.write(bytes);
		os.close();

	}
}
