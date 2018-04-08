package com.github.chengzhx76.spring.ioc;

/**
 * @desc:
 * @author: hp
 * @date: 2018/4/8
 */
public class BeanReference {
    private String name;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
