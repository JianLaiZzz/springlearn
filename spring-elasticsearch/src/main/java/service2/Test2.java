package service2;

import com.example.springelasticsearch.Test;
import org.springframework.stereotype.Service;


@Service
public class Test2 implements Test {
    @Override
    public void say() {
        System.out.println("测试2222");
    }
}
