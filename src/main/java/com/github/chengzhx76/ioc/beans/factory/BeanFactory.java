package com.github.chengzhx76.ioc.beans.factory;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/24
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;
}
