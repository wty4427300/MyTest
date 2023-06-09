package com.concurrent.effectivenote;

/**
 * 实现clone的样板代码
 */
public class CloneTest implements Cloneable{
    public CloneTest clone(){
        try {
            return (CloneTest)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
