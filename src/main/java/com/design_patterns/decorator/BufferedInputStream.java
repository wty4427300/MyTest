package com.design_patterns.decorator;

import java.io.InputStream;

public class BufferedInputStream extends MyInputStream {
    protected volatile InputStream in;

    protected BufferedInputStream(InputStream in) {
        this.in = in;
    }

    //...实现基于缓存的读数据接口...
}
