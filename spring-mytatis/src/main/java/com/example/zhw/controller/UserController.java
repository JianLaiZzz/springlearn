package com.example.zhw.controller;

import com.example.zhw.service.UserService;
import com.example.zhw.service.impl.UesrServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author zhangwei
 * @date 2021/4/24 12:28
 **/
@RestController
@Slf4j
public class UserController
{

	@Autowired
	private UserService userService;

	@GetMapping(value = "/user")
	public HashMap<String, Object> getUser(Integer uid) throws Exception
	{
		// 模拟用户查询
		userService.get(uid);
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("uid", uid);
		hashMap.put("name", "name" + uid);
		return hashMap;
	}

}
