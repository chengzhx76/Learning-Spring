package com.github.chengzhx76.ioc.beans;

import com.github.chengzhx76.ioc.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/27
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
