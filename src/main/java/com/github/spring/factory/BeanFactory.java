package com.github.spring.factory;

import com.github.spring.BeanDefinition;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/24
 */
public interface BeanFactory {

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

    Object getBean(String name);
}
