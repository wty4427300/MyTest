package com;

import com.alibaba.fastjson.JSON;
import java.util.List;

public class main {
    public static void main(String[] args) {
        String test="[{\n" +
                "\t\"version\": 170844600,\n" +
                "\t\"id\": 97287283,\n" +
                "\t\"sourceTimestamp\": 1632921745,\n" +
                "\t\"sourcePosition\": \"13402733@391\",\n" +
                "\t\"safeSourcePosition\": \"13402040@391\",\n" +
                "\t\"sourceTxid\": \"0\",\n" +
                "\t\"source\": {\n" +
                "\t\t\"sourceType\": \"MySQL\",\n" +
                "\t\t\"version\": \"8.0.18\"\n" +
                "\t},\n" +
                "\t\"operation\": \"UPDATE\",\n" +
                "\t\"objectName\": \"dental.item\",\n" +
                "\t\"processTimestamps\": null,\n" +
                "\t\"tags\": {\n" +
                "\t\t\"thread_id\": \"6329098\",\n" +
                "\t\t\"readerThroughoutTime\": \"1632922024446\",\n" +
                "\t\t\"server_id\": \"1108927113\",\n" +
                "\t\t\"pk_uk_info\": \"{\\\"uk_item_code\\\":[\\\"item_code\\\"],\\\"PRIMARY\\\":[\\\"id\\\"]}\"\n" +
                "\t},\n" +
                "\t\"fields\": [{\n" +
                "\t\t\"name\": \"id\",\n" +
                "\t\t\"dataTypeNumber\": 8\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"gmt_create\",\n" +
                "\t\t\"dataTypeNumber\": 12\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"gmt_modified\",\n" +
                "\t\t\"dataTypeNumber\": 12\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"spu_id\",\n" +
                "\t\t\"dataTypeNumber\": 8\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"item_name\",\n" +
                "\t\t\"dataTypeNumber\": 253\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"item_code\",\n" +
                "\t\t\"dataTypeNumber\": 253\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"prop\",\n" +
                "\t\t\"dataTypeNumber\": 253\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"sold_price\",\n" +
                "\t\t\"dataTypeNumber\": 246\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"mark_price\",\n" +
                "\t\t\"dataTypeNumber\": 246\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"pic\",\n" +
                "\t\t\"dataTypeNumber\": 253\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"category_id\",\n" +
                "\t\t\"dataTypeNumber\": 8\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"sales\",\n" +
                "\t\t\"dataTypeNumber\": 3\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"status\",\n" +
                "\t\t\"dataTypeNumber\": 3\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"weight\",\n" +
                "\t\t\"dataTypeNumber\": 3\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"brand_id\",\n" +
                "\t\t\"dataTypeNumber\": 8\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"brand_name\",\n" +
                "\t\t\"dataTypeNumber\": 253\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"solution_id\",\n" +
                "\t\t\"dataTypeNumber\": 8\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"change_price\",\n" +
                "\t\t\"dataTypeNumber\": 3\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"reserve_num\",\n" +
                "\t\t\"dataTypeNumber\": 3\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"origin_sku_id\",\n" +
                "\t\t\"dataTypeNumber\": 253\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"origin_type\",\n" +
                "\t\t\"dataTypeNumber\": 253\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"origin_sku_info\",\n" +
                "\t\t\"dataTypeNumber\": 253\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"origin_sku_pro_name\",\n" +
                "\t\t\"dataTypeNumber\": 253\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"origin_sku_price\",\n" +
                "\t\t\"dataTypeNumber\": 246\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"statement_day\",\n" +
                "\t\t\"dataTypeNumber\": 3\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"is_fittings\",\n" +
                "\t\t\"dataTypeNumber\": 3\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"is_full_pay\",\n" +
                "\t\t\"dataTypeNumber\": 1\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"pay_ratio\",\n" +
                "\t\t\"dataTypeNumber\": 246\n" +
                "\t}],\n" +
                "\t\"beforeImages\": [{\n" +
                "\t\t\"precision\": 8,\n" +
                "\t\t\"value\": \"76\"\n" +
                "\t}, {\n" +
                "\t\t\"year\": 2021,\n" +
                "\t\t\"month\": 1,\n" +
                "\t\t\"day\": 27,\n" +
                "\t\t\"hour\": 15,\n" +
                "\t\t\"minute\": 34,\n" +
                "\t\t\"second\": 46,\n" +
                "\t\t\"millis\": 0\n" +
                "\t}, {\n" +
                "\t\t\"year\": 2021,\n" +
                "\t\t\"month\": 9,\n" +
                "\t\t\"day\": 28,\n" +
                "\t\t\"hour\": 11,\n" +
                "\t\t\"minute\": 16,\n" +
                "\t\t\"second\": 11,\n" +
                "\t\t\"millis\": 0\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 8,\n" +
                "\t\t\"value\": \"68\"\n" +
                "\t}, {\n" +
                "\t\t\"charset\": \"utf8mb4\",\n" +
                "\t\t\"value\": {\n" +
                "\t\t\t\"bytes\": \"è¶\\u0085å£°æ³¢æ´\\u0097ç\\u0089\\u0099-ä¿\\u009Då\\u0081¥ç\\u0089\\u0088\"\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"charset\": \"utf8mb4\",\n" +
                "\t\t\"value\": {\n" +
                "\t\t\t\"bytes\": \"f7b6fb70c75348f9a9764e3c794d768a\"\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"charset\": \"utf8mb4\",\n" +
                "\t\t\"value\": {\n" +
                "\t\t\t\"bytes\": \"2:9\"\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"value\": \"348.00\",\n" +
                "\t\t\"precision\": 5,\n" +
                "\t\t\"scale\": 2\n" +
                "\t}, {\n" +
                "\t\t\"value\": \"1050.00\",\n" +
                "\t\t\"precision\": 6,\n" +
                "\t\t\"scale\": 2\n" +
                "\t}, {\n" +
                "\t\t\"charset\": \"utf8mb4\",\n" +
                "\t\t\"value\": {\n" +
                "\t\t\t\"bytes\": \"https://chiyanshe-nowatermark.oss-cn-beijing.aliyuncs.com/normandy/1611132592214.jpg\"\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 8,\n" +
                "\t\t\"value\": \"2\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"15\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"0\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"50\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 8,\n" +
                "\t\t\"value\": \"6\"\n" +
                "\t}, {\n" +
                "\t\t\"charset\": \"utf8mb4\",\n" +
                "\t\t\"value\": {\n" +
                "\t\t\t\"bytes\": \"é½¿ç \\u0094ç¤¾å\\u008F£è\\u0085\\u0094\"\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 8,\n" +
                "\t\t\"value\": \"2\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"1\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"1\"\n" +
                "\t}, null, null, null, null, null, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"1\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"0\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 1,\n" +
                "\t\t\"value\": \"0\"\n" +
                "\t}, {\n" +
                "\t\t\"value\": \"1.00\",\n" +
                "\t\t\"precision\": 3,\n" +
                "\t\t\"scale\": 2\n" +
                "\t}],\n" +
                "\t\"afterImages\": [{\n" +
                "\t\t\"precision\": 8,\n" +
                "\t\t\"value\": \"76\"\n" +
                "\t}, {\n" +
                "\t\t\"year\": 2021,\n" +
                "\t\t\"month\": 1,\n" +
                "\t\t\"day\": 27,\n" +
                "\t\t\"hour\": 15,\n" +
                "\t\t\"minute\": 34,\n" +
                "\t\t\"second\": 46,\n" +
                "\t\t\"millis\": 0\n" +
                "\t}, {\n" +
                "\t\t\"year\": 2021,\n" +
                "\t\t\"month\": 9,\n" +
                "\t\t\"day\": 29,\n" +
                "\t\t\"hour\": 21,\n" +
                "\t\t\"minute\": 22,\n" +
                "\t\t\"second\": 25,\n" +
                "\t\t\"millis\": 0\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 8,\n" +
                "\t\t\"value\": \"68\"\n" +
                "\t}, {\n" +
                "\t\t\"charset\": \"utf8mb4\",\n" +
                "\t\t\"value\": {\n" +
                "\t\t\t\"bytes\": \"è¶\\u0085å£°æ³¢æ´\\u0097ç\\u0089\\u0099-ä¿\\u009Då\\u0081¥ç\\u0089\\u0088\"\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"charset\": \"utf8mb4\",\n" +
                "\t\t\"value\": {\n" +
                "\t\t\t\"bytes\": \"f7b6fb70c75348f9a9764e3c794d768a\"\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"charset\": \"utf8mb4\",\n" +
                "\t\t\"value\": {\n" +
                "\t\t\t\"bytes\": \"2:9\"\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"value\": \"149.00\",\n" +
                "\t\t\"precision\": 5,\n" +
                "\t\t\"scale\": 2\n" +
                "\t}, {\n" +
                "\t\t\"value\": \"1050.00\",\n" +
                "\t\t\"precision\": 6,\n" +
                "\t\t\"scale\": 2\n" +
                "\t}, {\n" +
                "\t\t\"charset\": \"utf8mb4\",\n" +
                "\t\t\"value\": {\n" +
                "\t\t\t\"bytes\": \"https://chiyanshe-nowatermark.oss-cn-beijing.aliyuncs.com/normandy/1611132592214.jpg\"\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 8,\n" +
                "\t\t\"value\": \"2\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"15\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"0\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"50\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 8,\n" +
                "\t\t\"value\": \"6\"\n" +
                "\t}, {\n" +
                "\t\t\"charset\": \"utf8mb4\",\n" +
                "\t\t\"value\": {\n" +
                "\t\t\t\"bytes\": \"é½¿ç \\u0094ç¤¾å\\u008F£è\\u0085\\u0094\"\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 8,\n" +
                "\t\t\"value\": \"2\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"1\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"1\"\n" +
                "\t}, null, null, null, null, null, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"1\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 4,\n" +
                "\t\t\"value\": \"0\"\n" +
                "\t}, {\n" +
                "\t\t\"precision\": 1,\n" +
                "\t\t\"value\": \"0\"\n" +
                "\t}, {\n" +
                "\t\t\"value\": \"1.00\",\n" +
                "\t\t\"precision\": 3,\n" +
                "\t\t\"scale\": 2\n" +
                "\t}]\n" +
                "}]";
        List<String> strings = JSON.parseArray(test, String.class);
        strings.stream().forEach(
                it->{
                    String fields = JSON.parseObject(it).get("fields").toString();
                    List<String> parseArray = JSON.parseArray(fields, String.class);
                    parseArray.stream().forEach(
                            s->{
                                System.out.println(s);
                            }
                    );
                }
        );
    }
}
