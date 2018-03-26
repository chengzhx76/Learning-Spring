package com.github.spring;

/**
 * @desc: bean属性注入
 * @author: hp
 * @date: 2018/3/26
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
