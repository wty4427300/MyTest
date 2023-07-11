package com.accesslimit.src;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 限流注解，默认1秒5个
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface AccessLimit {

    /**
     * 统计接口调用次数的时间
     */
    int seconds() default 1;

    /**
     * 最大调用次数
     */
    int maxCount() default 5;
}
