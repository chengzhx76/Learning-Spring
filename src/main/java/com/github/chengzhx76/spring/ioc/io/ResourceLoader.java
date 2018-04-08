package com.github.chengzhx76.spring.ioc.io;

import java.net.URL;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/27
 */
public class ResourceLoader {
    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
