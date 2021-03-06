package com.github.chengzhx76.test.spring;

import com.github.chengzhx76.ioc.beans.BeanDefinition;
import com.github.chengzhx76.ioc.beans.factory.AutowrieCapableBeanFactory;
import com.github.chengzhx76.ioc.beans.io.ResourceLoader;
import com.github.chengzhx76.ioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/24
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws Exception {
        testLazy();
    }


    public static void testLazy() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("cheng.xml");

        // 2.初始化beanFactory并注册bean
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        AutowrieCapableBeanFactory beanFactory = new AutowrieCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : registry.entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        beanFactory.preInstantiateSingletons();

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
//        helloWorldService.say();
        helloWorldService.sayUser();
    }

}
