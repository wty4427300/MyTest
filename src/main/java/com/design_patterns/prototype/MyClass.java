package com.design_patterns.prototype;


class NestedClass implements Cloneable {
    private final String name;

    public NestedClass(String name) {
        this.name = name;
    }

    // Getters and setters

    @Override
    public NestedClass clone() {
        try {
            return (NestedClass) super.clone();
        } catch (CloneNotSupportedException e) {
            // Handle clone not supported exception
            return null;
        }
    }
}

public class MyClass implements Cloneable {
    private int number;
    private NestedClass nested;

    public MyClass(int number, NestedClass nested) {
        this.number = number;
        this.nested = nested;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public NestedClass getNested() {
        return nested;
    }

    public void setNested(NestedClass nested) {
        this.nested = nested;
    }

    @Override
    public MyClass clone() {
        try {
            MyClass cloned = (MyClass) super.clone();
            // Perform deep copy for nested object
            cloned.nested = nested.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            // Handle clone not supported exception
            return null;
        }
    }

    public static void main(String[] args) {
        // 创建原型对象
        NestedClass nested = new NestedClass("Nested");
        MyClass original = new MyClass(10, nested);

        // 浅拷贝
        MyClass shallowCopy = original.clone();
        System.out.println("Original and shallow copy:");
        System.out.println(original == shallowCopy); // false
        System.out.println(original.getNested() == shallowCopy.getNested()); // true

        // 深拷贝
        MyClass deepCopy = original.clone();
        System.out.println("Original and deep copy:");
        System.out.println(original == deepCopy); // false
        System.out.println(original.getNested() == deepCopy.getNested()); // false
    }
}

