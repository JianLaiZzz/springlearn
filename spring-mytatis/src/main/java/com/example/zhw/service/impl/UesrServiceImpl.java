package com.example.zhw.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.zhw.entry.User;
import com.example.zhw.mapper.UserMapper;
import com.example.zhw.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: zhw
 * @createDate: 2020/4/19
 */
@Service
public class UesrServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{

}
