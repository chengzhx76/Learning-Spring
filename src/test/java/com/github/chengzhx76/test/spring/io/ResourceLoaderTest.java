package com.github.chengzhx76.test.spring.io;

import com.github.chengzhx76.spring.ioc.io.Resource;
import com.github.chengzhx76.spring.ioc.io.ResourceLoader;
import com.xiaoleilu.hutool.io.IoUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/30
 */
public class ResourceLoaderTest {
    public static void main(String[] args) throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("cheng.xml");
        InputStream stream = resource.getInputStream();

        System.out.println(IoUtil.read(stream));

        System.out.println(stream != null);
    }
}
