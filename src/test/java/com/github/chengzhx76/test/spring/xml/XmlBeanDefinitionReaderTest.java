package com.github.chengzhx76.test.spring.xml;

import com.github.chengzhx76.ioc.beans.BeanDefinition;
import com.github.chengzhx76.ioc.beans.io.ResourceLoader;
import com.github.chengzhx76.ioc.beans.xml.XmlBeanDefinitionReader;

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
