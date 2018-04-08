package com.github.spring.test.xml;

import com.github.spring.BeanDefinition;
import com.github.chengzhx76.spring.ioc.io.ResourceLoader;
import com.github.chengzhx76.spring.ioc.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/30
 */
public class XmlBeanDefinitionReaderTest {

    public static void main(String[] args) throws Exception {
//        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("cheng.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();

        System.out.println(registry.size() > 0);
    }
}
