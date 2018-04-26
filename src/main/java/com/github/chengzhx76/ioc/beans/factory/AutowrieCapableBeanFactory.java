package com.github.chengzhx76.ioc.beans.factory;

import com.github.chengzhx76.ioc.BeanReference;
import com.github.chengzhx76.ioc.beans.BeanDefinition;
import com.github.chengzhx76.ioc.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * @desc: 可自动装配内容的BeanFactory
 * @author: hp
 * @date: 2018/3/24
 */
public class AutowrieCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    /**
     * 创建实例
     * @param beanDefinition
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);

            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }

    }

}
