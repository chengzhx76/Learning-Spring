package com.github.chengzhx76.mode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Desc:
 * Author: 光灿
 * Date: 2017/7/27
 */
@Configuration
public class Beans {

    @Bean(name = "car")
    public Car buildCart() {
        Car car = new Car();
        car.setSpeed("111");
        return car;
    }

    public static void main(String[] args) {
    }


}
