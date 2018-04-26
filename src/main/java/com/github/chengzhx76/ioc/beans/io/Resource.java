package com.github.chengzhx76.ioc.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @desc: spring内部定位资源接口
 * @author: hp
 * @date: 2018/3/27
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
