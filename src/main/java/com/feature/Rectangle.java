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

    /**
     * 类型匹配就是在instanceof之后自动转换出一个临时变量
     * 节省了用判断类型并强转的过程
     */
    public static boolean isRectangle(Shape shape) {
        if (shape instanceof Rectangle rect) {
            return rect.length == rect.width;
        } else {
            return false;
        }
    }

    public static boolean test(Shape shape) {
        if (!(shape instanceof Rectangle rect)) {
            return false;
        } else {
            return (rect.length == rect.width);
        }
    }
}
