package com.example.zhw.controller;

import com.example.zhw.entry.UserEntity;
import com.example.zhw.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: zhw
 * @createDate: 2020/4/19
 */
@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {
    // redis中存储的过期时间60s
    private static int ExpireTime = 60;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("set")
    public boolean redisset(String key, String value) {
        UserEntity userEntity = new UserEntity();
//		userEntity.setId(Long.valueOf(1));
//		userEntity.setGuid(String.valueOf(1));
//		userEntity.setName("zhangsan");
//		userEntity.setAge(String.valueOf(20));
//		userEntity.setCreateTime(new Date());

        //return redisUtil.set(key,userEntity,ExpireTime);

        return false;
    }

    @RequestMapping("get")
    public Object redisget(String key) {
//        Object ob = redisTemplate.
//                System.out.println(ob);
//        return redisUtil.get(key);

        return null;
    }

    @RequestMapping("expire")
    public boolean expire(String key) {
        return false;
    }
}
