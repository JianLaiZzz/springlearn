package com.example.zhw;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@RestController
@Slf4j
public class AlibabaApplication
{

	private static String TEST_STRING = "test";

	private static LocalDateTime time = LocalDateTime.now(ZoneId.of(ZoneOffset.ofHours(8).getId()));

	public static void main(String[] args)
	{
		SpringApplication.run(AlibabaApplication.class, args);
	}

	private int counter = 0;

	private double print(String s)
	{

		String badName;

		System.out.println(s);

		int delay = ThreadLocalRandom.current().nextInt(3000);

		try
		{
			Thread.sleep(delay);
		}
		catch (InterruptedException e)
		{
		}

		if (delay % 3 == 0)
		{
			throw new IllegalStateException("test exception");
		}
		return Math.random();

	}

	@GetMapping("/")
	public String root()
	{

		return "Maven Spring Boot Application started at ------ " + time;
	}

	@Bean
	public CommandLineRunner runner()
	{

		return args ->
		{

			while (true)
			{

				String msg = LocalDateTime.now(ZoneId.of(ZoneOffset.ofHours(8).getId())).toString() + " "
						+ counter++;

				try
				{

					print(msg);

				}
				catch (Exception e)
				{

				}

				Thread.sleep(333);

			}

		};

	}

}
