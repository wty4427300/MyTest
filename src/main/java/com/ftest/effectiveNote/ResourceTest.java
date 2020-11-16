package com.ftest.effectiveNote;

import java.io.*;

public class ResourceTest {

    /**
     * 我们一个资源的打开写在了try后面的括号里面,当抛出异常的时候就会自动关闭资源
     * 有点类似析构函数吧,平时挺少写的.
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static String FirstLineOfFile(String path) throws IOException {
        try(BufferedReader br=new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }

    /**
     * 也可写多个资源控制,用;隔开
     *
     * @param src
     * @param dst
     * @throws IOException
     */
    public void copy(String src,String dst) throws IOException {
        try(InputStream in=new FileInputStream(src);OutputStream out=new FileOutputStream(dst)){
            byte[] bytes=new byte[1024];
            int n;
            while ((n=in.read(bytes))>=0){
                out.write(bytes,0,n);
            }
        }
    }
}
