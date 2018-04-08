package com.github.chengzhx76.spring.ioc.factory;

import com.github.chengzhx76.spring.ioc.BeanDefinition;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/24
 */
public interface BeanFactory {

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

    Object getBean(String name) throws Exception;
}
