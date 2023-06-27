package com.design_patterns.decorator;

import java.io.IOException;
import java.io.InputStream;

public class DataInputStream extends MyInputStream {
    protected volatile InputStream in;

    protected DataInputStream(InputStream in) {
        this.in = in;
    }


    //...实现读取基本类型数据的接口
}
