package com.example.zhw.common.controller;


import lombok.extern.slf4j.Slf4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "common")
@RequestMapping(value = "hello")
@Slf4j
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);


    @GetMapping("/hello")
    public void hello() {
        log.info("刘亦菲");
    }


}
