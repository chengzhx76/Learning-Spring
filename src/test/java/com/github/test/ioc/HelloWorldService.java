package com.github.test.ioc;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/24
 */
public class HelloWorldService {

    private String text;

    public void say() {
        System.out.println(text);
    }

//    public void setText(String text) {
//        this.text = text;
//    }
}