package com.github.chengzhx76.ioc.context;

import com.github.chengzhx76.ioc.beans.BeanDefinition;
import com.github.chengzhx76.ioc.beans.factory.AbstractBeanFactory;
import com.github.chengzhx76.ioc.beans.factory.AutowrieCapableBeanFactory;
import com.github.chengzhx76.ioc.beans.io.ResourceLoader;
import com.github.chengzhx76.ioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2018/4/26
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowrieCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition(configLocation);
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : registry.entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
