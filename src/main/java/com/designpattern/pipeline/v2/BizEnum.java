package com.designpattern.pipeline.v2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum BizEnum {

    TRAFFIC_EVENT(1, "业务1"),
    METRIC_EVENT(2, "业务2"),
    SIGNAL_EVENT(3, "业务3");

    private Integer code;
    private String name;

    private static final Map<Integer, BizEnum> map = new HashMap<>();

    static {
        for (BizEnum bizEnum : BizEnum.values()) {
            map.put(bizEnum.getCode(), bizEnum);
        }
    }

    BizEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static Optional<BizEnum> of(Integer code) {
        return Optional.ofNullable(map.get(code));
    }

}
