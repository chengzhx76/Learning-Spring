package com.github.test.ioc;

import com.github.chengzhx76.mode.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Desc:
 * Author: 光灿
 * Date: 2017/8/27
 */
public class LoadXml {

    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("/bean.xml");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(resource);
        Car car = factory.getBean("car", Car.class);

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
