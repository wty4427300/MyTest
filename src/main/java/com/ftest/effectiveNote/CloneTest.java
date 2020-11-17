package com.ftest.effectiveNote;

/**
 * 实现clonexus'/'/的样板代码
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
