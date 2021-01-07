package com.example.zhw.springsource.factory;

import com.example.zhw.springsource.bean.Dog;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author zhangwei1
 * @date 2020/7/3 14:25
 */
@Component("factoryBeanTest")
public class FactoryBeanTest implements FactoryBean<Dog> {

    //    BeanFactory： 以Factory结尾，表示它是一bai个工厂类，是用于管理Bean的一个工厂
    //    FactoryBean：以Bean结尾，表示它是一个Bean，不同于普通Bean的是：它是实现了FactoryBean<T>接口的Bean，
    //    根据该Bean的Id从BeanFactory中获取的实际上是FactoryBean的getObject()返回的对象，而不是FactoryBean本身，
    //    如果要获取FactoryBean对象，可以在id前面加一个&符号来获取。

    @Override
    public Dog getObject() throws Exception {
        return new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }
}