package com.github.spring.test;

import com.github.spring.BeanDefinition;
import com.github.spring.PropertyValue;
import com.github.spring.PropertyValues;
import com.github.spring.factory.BeanFactory;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/24
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws Exception {
        // 1.初始化BeanFactory
        BeanFactory beanFactory = new AutowrieCapableBeanFactory();

        // 2.bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.github.spring.test.HelloWorldService");

        // 3.设置属性值
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World !~~~"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4.注入bean
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 5.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.say();
    }

}
