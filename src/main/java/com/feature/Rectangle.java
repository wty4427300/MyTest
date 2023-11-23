package com.feature;

public final class Rectangle extends Shape {

    public final double length;
    public final double width;

    public Rectangle(String id, double length, double width) {
        super(id);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    public static boolean isRectangle(Shape shape) {
        return shape instanceof Rectangle rectangle;
    }
}
