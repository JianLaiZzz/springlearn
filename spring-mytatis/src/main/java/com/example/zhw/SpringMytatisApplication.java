package com.example.zhw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class SpringMytatisApplication
{
	@Value("${server.port}")
	private int port;

	public static void main(String[] args)
	{
		SpringApplication.run(SpringMytatisApplication.class, args);
	}

	@EventListener({ ApplicationReadyEvent.class })
	void applicationReadyEvent()
	{
		System.out.println("应用已经准备就绪 ... 启动浏览器");
		System.out.println("端口：" + port);
		String url = "http://localhost:" + port + "/hello";
		Runtime runtime = Runtime.getRuntime();
		try
		{
			runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
