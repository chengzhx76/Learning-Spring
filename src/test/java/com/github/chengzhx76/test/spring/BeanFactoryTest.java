package com.github.chengzhx76.test.spring;

import com.github.chengzhx76.spring.ioc.BeanDefinition;
import com.github.chengzhx76.spring.ioc.factory.AutowrieCapableBeanFactory;
import com.github.chengzhx76.spring.ioc.factory.BeanFactory;
import com.github.chengzhx76.spring.ioc.io.ResourceLoader;
import com.github.chengzhx76.spring.ioc.xml.XmlBeanDefinitionReader;

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
