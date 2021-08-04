package com.example.zhw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zhw.entry.User;

/**
 * @author: zhw
 * @createDate: 2020/4/19
 */
public interface UserService extends IService<User>
{

	void get(Integer uid) throws Exception;
}
