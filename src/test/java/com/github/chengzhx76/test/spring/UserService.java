package com.github.chengzhx76.test.spring;

/**
 * @desc:
 * @author: hp
 * @date: 2018/4/9
 */
public class UserService {

    private String name;

    public void sayName() {
        System.out.println(this.name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
