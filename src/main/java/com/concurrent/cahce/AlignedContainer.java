package com.concurrent.cahce;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 尝试写一个字节对齐的容器，虽然并没啥用
 */
public class AlignedContainer<T> {
    public static Unsafe UNSAFE = null;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            UNSAFE = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static final long BASE_OFFSET = UNSAFE.arrayBaseOffset(Object[].class);
    private static final int ELEMENT_SIZE = 8; // 8 bytes alignment, you can change this as needed
    private final Object[] buffer;

    public AlignedContainer(int capacity) {
        int alignedCapacity = align(capacity);
        buffer = new Object[alignedCapacity];
    }

    private int align(int capacity) {
        int alignedCapacity = capacity;
        if (capacity % ELEMENT_SIZE != 0) {
            alignedCapacity += ELEMENT_SIZE - (capacity % ELEMENT_SIZE);
        }
        return alignedCapacity;
    }

    public void set(int index, T value) {
        UNSAFE.putObject(buffer, BASE_OFFSET + (long) index * ELEMENT_SIZE, value);
    }

    public T get(int index) {
        return (T) UNSAFE.getObject(buffer, BASE_OFFSET + (long) index * ELEMENT_SIZE);
    }

    public static void main(String[] args) {
        // 创建一个容量为 10 的字节对齐的容器，存储字符串类型
        AlignedContainer<String> container = new AlignedContainer<>(10);

        // 设置和获取值
        container.set(0, "Hello");
        String value = container.get(0);
        System.out.println("Value at index 0: " + value);
    }
}
