package com.test;

import cn.hutool.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 根据i18n处理不同文本
 */
public class test18 {

    public List<String> handlePurchaseNotice(String purchaseNotice, Locale locale) {
        if (StringUtils.isEmpty(purchaseNotice)) {
            return new ArrayList<>();
        }
        String[] parts;
        if (locale.equals(Locale.CHINA)) {
            parts = purchaseNotice.split("\\d+、\\s*");
        } else {
            parts = purchaseNotice.split("\\d+\\.\\s*");
        }

        //处理分割后的结果
        return Arrays.stream(parts).filter(StringUtils::isNotEmpty).map(String::trim).toList();
    }

    public static void main(String[] args) {
        test18 test18 = new test18();
        List<String> result = test18.handlePurchaseNotice("1、本商品仅限仍在保修期内的产品延长保修期使用；2、同一设备只能购买一次延保有效订单的延保将于下单后1-3个工作日生效；3、您可以关注【360智慧生活服务】，点击菜单栏-自助查询-保修期查询，关注延保的生效情况。", Locale.CHINA);
        System.out.println(JSONUtil.toJsonStr(result));
        List<String> result1 = test18.handlePurchaseNotice("1. This product can only be used to extend the warranty period for products that are still within the warranty period; 2. The same device can only be purchased once for an extended warranty. The extended warranty for a valid order will take effect 1-3 working days after the order is placed; 3. You can Pay attention to [360 Smart Life Service], click the menu bar-self-service inquiry-warranty period inquiry, and pay attention to the effectiveness of the extended warranty.", Locale.ENGLISH);
        System.out.println(JSONUtil.toJsonStr(result1));
        List<String> list = JSONUtil.toList("[本商品仅限仍在保修期内的产品延长保修期使用；, 同一设备只能购买一次延保有效订单的延保将于下单后1-3个工作日生效；, 您可以关注【360智慧生活服务】，点击菜单栏-自助查询-保修期查询，关注延保的生效情况。]", String.class);
        System.out.println(list);
        String json="[\"本商品仅限仍在保修期内的产品延长保修期使用；\",\"同一设备只能购买一次延保有效订单的延保将于下单后1-3个工作日生效；\",\"您可以关注【360智慧生活服务】，点击菜单栏-自助查询-保修期查询，关注延保的生效情况。\"]";
        String json2="[\"This product can only be used to extend the warranty period for products that are still within the warranty period;\",\"The same device can only be purchased once for an extended warranty. The extended warranty for a valid order will take effect 1-3 working days after the order is placed;\",\"You can Pay attention to [360 Smart Life Service], click the menu bar-self-service inquiry-warranty period inquiry, and pay attention to the effectiveness of the extended warranty.\"]";
    }
}
