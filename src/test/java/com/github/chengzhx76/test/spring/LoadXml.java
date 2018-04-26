package com.github.chengzhx76.test.spring;

import com.github.chengzhx76.mode.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Desc:
 * Author: 光灿
 * Date: 2017/8/27
 */
public class LoadXml {

    public static void main(String[] args) {
//        ClassPathResource resource = new ClassPathResource("/bean.xml");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions("/bean.xml");
//        Car car = (Car) factory.getBean("&car");
        Car car2 = (Car) factory.getBean("car");
        Car car3 = (Car) factory.getBean("car");

        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/bean.xml");
        Car car = (Car) context.getBean("car");


        System.out.println("-----" + car);*/


        /*ResourceLoader loader = new PathMatchingResourcePatternResolver();
        Resource resource = loader.getResource("/bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        Car car = (Car) factory.getBean("car");
        System.out.println(car);*/
    }

}
