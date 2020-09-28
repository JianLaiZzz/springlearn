package service;

import com.example.springelasticsearch.Test;
import org.springframework.stereotype.Service;

@Service
public class Test1 implements Test {
    @Override
    public void say() {

        System.out.println("测试1111");
    }
}
