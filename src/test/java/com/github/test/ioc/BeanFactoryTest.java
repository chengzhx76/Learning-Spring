package com.github.test.ioc;

import com.github.chengzhx76.spring.BeanDefinition;
import com.github.chengzhx76.spring.PropertyValue;
import com.github.chengzhx76.spring.PropertyValues;
import com.github.chengzhx76.spring.ioc.factory.BeanFactory;

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
