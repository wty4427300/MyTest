package com.design_patterns.pipeline.v2.test.pojo;


import lombok.Data;

@Data
public class ChargeRequest {

  private String bizCode;

  private Long userId;

  private Long stakeId;

  private String carNo;

  private String extra;

}
