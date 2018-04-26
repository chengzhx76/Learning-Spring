package com.github.chengzhx76.ioc.context;

import com.github.chengzhx76.ioc.beans.factory.AbstractBeanFactory;

/**
 * @desc:
 * @author: hp
 * @date: 2018/4/26
 */
public class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
