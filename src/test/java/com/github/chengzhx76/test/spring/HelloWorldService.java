package com.github.chengzhx76.test.spring;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/24
 */
public class HelloWorldService {

    private String text;

    private UserService userService;

    public void say() {
        System.out.println(text);
    }

    public void sayUser() {
        userService.sayName();
    }

//    public void setText(String text) {
//        this.text = text;
//    }


}
