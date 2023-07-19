package com.test;

import java.util.Arrays;
import java.util.List;

public class test11 {
    public static void main(String[] args) {
        List<Integer> id= Arrays.asList(436,
                437,
                438,
                439,
                440,
                441,
                442,
                443,
                444,
                445,
                446,
                447,
                448,
                449,
                450,
                451,
                452,
                454,
                455,
                456,
                457);
        System.out.println("insert into hearing_channel_doctor (channel_id, doctor_id, channel_code, status, gmt_create, gmt_modified) values");
        id.forEach(
                it->{
                    System.out.println("("+"1,"+it+","+ "'hk-" +it+ "'," +"0,"+"now(),"+"now()"+"),");
                }
        );
    }
}
