package com.example.springelasticsearch.controller;

import com.example.springelasticsearch.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestController {


    @Autowired
    private Test test;

    @GetMapping("/hello")
    public  void say(){
        test.say();
    }

}
