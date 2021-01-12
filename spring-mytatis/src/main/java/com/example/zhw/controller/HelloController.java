package com.example.zhw.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.example.zhw.entry.User;
import com.example.zhw.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mobileCodeWS.MobileCodeWSSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public String hello() throws MalformedURLException {
        Wrapper<User> wrapper = new EntityWrapper();
        List<User> map = userService.selectList(wrapper);


        List<String> nameList = new ArrayList<>();
        map.forEach(user ->
        {

            nameList.add(user.getUsername());
        });

        return nameList.toString();
    }


    @GetMapping("/add")
    @ApiOperation(value = "add方法")
    public void add(String name) throws MalformedURLException {
        User user = new User(name, "13132", new Date());
        userService.insert(user);
    }
}
