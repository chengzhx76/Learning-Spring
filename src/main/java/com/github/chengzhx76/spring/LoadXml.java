package com.github.chengzhx76.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Desc:
 * Author: 光灿
 * Date: 2017/8/27
 */
public class LoadXml {

    public static void main(String[] args) {
        /*ClassPathResource resource = new ClassPathResource("/bean.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(resource);
        Car car = (Car) factory.getBean("car");
        */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/bean.xml");
        Car car = (Car) context.getBean("car");


        System.out.println("-----" + car);

    }

}
