package com.feature;


/**
 * sealed封闭类,permits指定允许扩展该封闭类的子类
 * permits指定的子类必须和sealed封闭类在一个module or package
 * 里
 */
public abstract sealed class Shape permits Rectangle {
    public final String id;

    public Shape(String id) {
        this.id = id;
    }

    public abstract double area();
}
