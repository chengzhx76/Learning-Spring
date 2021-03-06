package com.github.chengzhx76.ioc.beans;

/**
 * @desc: 从配置文件中读取BeanDefinitionReader
 * @author: hp
 * @date: 2018/3/27
 */
public interface BeanDefinitionReader {

    void loadBeanDefinition(String location) throws Exception;
}
