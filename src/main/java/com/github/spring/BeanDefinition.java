package com.github.spring;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/24
 */
public class BeanDefinition {

    private Object bean;

    private String beanClassName;

    private Class beanClass;

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }
}