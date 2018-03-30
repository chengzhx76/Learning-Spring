package com.github.spring.test;

import com.github.spring.BeanDefinition;
import com.github.spring.factory.AutowrieCapableBeanFactory;
import com.github.spring.factory.BeanFactory;
import com.github.spring.io.ResourceLoader;
import com.github.spring.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/24
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("cheng.xml");

        // 2.初始化beanFactory并注册bean
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        BeanFactory beanFactory = new AutowrieCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : registry.entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.say();
    }

}
