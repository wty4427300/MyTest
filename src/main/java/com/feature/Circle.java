package com.feature;

/**
 * 档案类record相当于class,形式上可以看作是构造方法
 * 用来构造不可变的类
 * 内置了缺省的 equals 方法、hashCode 方法以及 toString 方法
 * 当对象构造传入值相同时,这两个类相同
 * 是一个final类,父类为java.lang.Record
 */
public record Circle(double radius) {

    public Circle {
        if (radius < 0) {
            throw new IllegalArgumentException("The radius of a circle cannot be negative [" + radius + "]");
        }
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle(10.0);
        Circle circle2 = new Circle(10.0);
        boolean result = circle1.equals(circle2);
        System.out.println(result);
        double radius = circle1.radius();
        System.out.println(radius);
    }
}
