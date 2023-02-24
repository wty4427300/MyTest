package com.func;

import org.apache.commons.lang3.StringUtils;

public class VUtils {

    public static ThrowExceptionFunction isTrue(boolean b){
        return (message)->{
            if (b){
                throw new RuntimeException(message);
            }
        };
    }

    public static PresentOrElseHandler<?> isBlankOrNoBlank(String str){
        return (consumer, runnable) -> {
            if (StringUtils.isEmpty(str)){
                runnable.run();
            } else {
                consumer.accept(str);
            }
        };
    }

    public static BranchHandle isTureOrFalse(boolean b){
        return (trueHandle, falseHandle) -> {
            if (b){
                trueHandle.run();
            } else {
                falseHandle.run();
            }
        };
    }

    public static void main(String[] args) {
        VUtils.isTrue(true).throwMessage("错误");
    }
}
