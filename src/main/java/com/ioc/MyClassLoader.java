package com.ioc;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);
        //字节码转class对象
        return defineClass(name, data, 0, data.length);
    }

    /**
     * 加载字节码
     */
    private byte[] loadClassData(String name) throws ClassNotFoundException {
        String fileName = classPath + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
        try (InputStream in = Files.newInputStream(Paths.get(fileName));
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int len;
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            return out.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException("Failed to load class data: " + name, e);
        }
    }

    public static void main(String[] args) throws RuntimeException {
        MyClassLoader classLoader = new MyClassLoader("MyClassLoader.class");
        try {
            Class<?> clazz = classLoader.loadClass("com.ioc.MyClassLoader");
            Object obj = clazz.getDeclaredConstructor().newInstance();
            // 使用加载的类进行操作
            // ...
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}