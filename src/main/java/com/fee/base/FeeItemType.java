package com.fee.base;


import java.util.Optional;

/**
 * 为了区分不同费用不同计算方式
 */
public enum FeeItemType implements BaseEnum<FeeItemType> {

    SERVICE_FEE(1, "服务费"),
    POSTAGE_FEE(2, "邮费"),
    PACK_FEE(3, "打包费"),
    OVER_TIME_FEE(4, "超时费");

    FeeItemType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private Integer code;
    private String name;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static Optional<FeeItemType> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(FeeItemType.class, code));
    }

}
