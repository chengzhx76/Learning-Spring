package com.github.chengzhx76.test.spring.context;

import com.github.chengzhx76.ioc.context.ApplicationContext;
import com.github.chengzhx76.ioc.context.ClassPathXmlApplicationContext;
import com.github.chengzhx76.test.spring.HelloWorldService;

/**
 * @desc:
 * @author: hp
 * @date: 2018/4/26
 */
public class ApplicationContextTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cheng.xml");
        HelloWorldService service = (HelloWorldService) applicationContext.getBean("helloWorldService");
        service.sayUser();
    }

}
