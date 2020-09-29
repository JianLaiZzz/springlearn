package com.example.zhw.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {


    @Test
    public void test2(){
        log.debug("debug啥打法是否");//默认日志级别为info
        log.info("info阿范德萨");
        log.error("error 阿范德萨");
        log.warn("warn 阿范德萨");
    }
}
