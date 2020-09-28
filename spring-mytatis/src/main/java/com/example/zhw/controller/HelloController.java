package com.example.zhw.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.example.zhw.entry.User;
import com.example.zhw.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: zhw
 * @createDate: 2020/4/19
 */
@RestController
@Api("hello基础文档")
public class HelloController {
    @Value("${value}")
    private String value;

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    @ApiOperation(value = "hello方法")
    public String hello() {
        Wrapper<User> wrapper = new EntityWrapper();
        Map<String, Object> map = userService.selectMap(wrapper);
        map.forEach((k, v) ->
        {
            System.out.println(k + ":" + v);
        });

        return value;
    }
}
