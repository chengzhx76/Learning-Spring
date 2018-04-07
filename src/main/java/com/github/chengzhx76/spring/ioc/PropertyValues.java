package com.github.chengzhx76.spring.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: bean属性集合；包装一个对象的PropertyValue,相比List更灵活
 * @author: hp
 * @date: 2018/3/24
 */
public class PropertyValues {
    private List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        // TODO 这里可以对于重复propertyName进行判断，直接用list没法做到
        this.propertyValues.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }
}
