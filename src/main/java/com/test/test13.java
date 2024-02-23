package com.test;

import lombok.Data;

@Data
class UserT{
    private int id;
    private String name;
}

public class test13 {

    public static void main(String[] args) {
        UserT userT=new UserT();
    }
}
