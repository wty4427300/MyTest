package com.myparser;

public interface Token {
    //token的类型
    public TokenType getType();

    public String getText();
}
