package com.github.spring.factory;

import com.github.spring.BeanDefinition;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/24
 */
public class AutowrieCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
