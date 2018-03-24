package com.github.spring.test;

import com.github.spring.BeanDefinition;
import com.github.spring.factory.AutowrieCapableBeanFactory;
import com.github.spring.factory.BeanFactory;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/24
 */
public class BeanFactoryTest {

    public static void main(String[] args) {
        // 1.初始化BeanFactory
        BeanFactory beanFactory = new AutowrieCapableBeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.github.spring.test.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.say();
    }

}
