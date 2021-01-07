package com.example.zhw.springsource;

import com.example.zhw.springsource.bean.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringsourceApplication {

    public static void main(String[] args) {
        //		System.out.println("zhagwwerwer１１2121111");
        //		//        SpringApplication.run(SpringsourceApplication.class, args);
        //		System.out.println("hehhe1113213123123");
        //
        //		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //		Dog person = (Dog) context.getBean("person");

        SpringApplication.run(SpringsourceApplication.class, args);
    }

    public void say() {

    }
}
