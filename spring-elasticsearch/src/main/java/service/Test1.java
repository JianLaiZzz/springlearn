package service;

import com.example.zhw.springelasticsearch.Test;
import org.springframework.stereotype.Service;

@Service
public class Test1 implements Test
{
	@Override
	public void say()
	{

		System.out.println("测试1111");
	}
}
