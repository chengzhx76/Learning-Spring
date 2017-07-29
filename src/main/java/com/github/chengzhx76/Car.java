package com.github.chengzhx76;

/**
 * Desc:
 * Author: 光灿
 * Date: 2017/7/27
 */
public class Car {
    private String brand;
    private String speed;

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getSpeed() {
        return speed;
    }

    public Car setSpeed(String speed) {
        this.speed = speed;
        return this;
    }
}