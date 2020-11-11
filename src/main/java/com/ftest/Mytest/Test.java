package com.ftest.Mytest;

public class Test {
    public static void main(String[] args) {

    }

    /**
     * 1.静态工厂方法(非设计模式里的方法) 代替构造器
     *
     * 2.因为同签名的构造方法只能有一个,换一下参数顺序虽然可行,但是可读性差
     * 而静态构造工厂则没有这个限制.
     *
     * 3.而且所有的静态工厂都是属于同一个类的,一直返回都是同一个类,类似与享元模式,避免了类的重复创建.
     *
     * 4.静态工厂可以返回子类,而构造器只能返回本类的实例,其实建造者模式使用的就是这种方式,不过是使用了内部类罢了
     */
    public static Boolean valueOf(boolean b){
        return b?Boolean.TRUE:Boolean.FALSE;
    }
}
