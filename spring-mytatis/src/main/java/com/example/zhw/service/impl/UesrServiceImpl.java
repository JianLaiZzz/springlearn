package com.example.zhw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zhw.entry.Assetstype;
import com.example.zhw.entry.User;
import com.example.zhw.mapper.AssetstypeMapper;
import com.example.zhw.mapper.UserMapper;
import com.example.zhw.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: zhw
 * @createDate: 2020/4/19
 */
@Service
@Transactional
@Slf4j
public class UesrServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{

	@Resource
	private AssetstypeMapper assetstypeMapper;

	@Override
	public void get(Integer uid) throws Exception
	{

		Assetstype assetstype = new Assetstype();
		assetstype.setAreaCode("zhangwei");
		assetstypeMapper.insert(assetstype);
		check(uid);
		service(uid);
		redis(uid);
		mysql(uid);

	}

	public void service(Integer uid) throws Exception
	{
		int count = 0;
		for (int i = 0; i < 10; i++)
		{
			count += i;
		}
		log.info("service  end {}", count);
	}

	public void redis(Integer uid) throws Exception
	{
		int count = 0;
		for (int i = 0; i < 10000; i++)
		{
			count += i;
		}
		log.info("redis  end {}", count);
	}

	public void mysql(Integer uid) throws Exception
	{
		long count = 0;
		for (int i = 0; i < 10000000; i++)
		{
			count += i;
		}
		log.info("mysql end {}", count);
	}

	public boolean check(Integer uid) throws Exception
	{
		if (uid == null || uid < 0)
		{
			log.error("uid不正确，uid:{}", uid);
			throw new Exception("uid不正确");
		}
		return true;
	}

}
