package com.mojing;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A dedicated test class to reproduce and isolate the server failure
 * when requesting page 2 with a page_size of 100 for a specific url_id.
 */
public class PageTwoTest {

    // --- Parameters for the specific failing test case ---
    private static final String API_KEY = "";
    private static final String TEST_URL_ID = "";
    private static final int PAGE_TO_TEST = 2;
    private static final int PAGE_SIZE_TO_TEST = 100;
    private static final String START_DATE = "2025-07";
    private static final String END_DATE = "2025-07";

    public static void main(String[] args) {
        ApiClient client = new ApiClient(API_KEY);
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("执行一个专门复现失败场景的测试...");
        System.out.printf("测试目标: url_id='%s', page=%d, page_size=%d\n",
                TEST_URL_ID, PAGE_TO_TEST, PAGE_SIZE_TO_TEST);
        System.out.println("--------------------------------------------------");

        // Construct the exact parameters that cause the failure
        Map<String, Object> params = new HashMap<>();
        params.put("url_id", TEST_URL_ID);
        params.put("start", START_DATE);
        params.put("end", END_DATE);
        params.put("sku", "false");
        params.put("page", PAGE_TO_TEST);
        params.put("page_size", PAGE_SIZE_TO_TEST);
        params.put("order_by", "sales");
        params.put("desc", "true");

        try {
            String paramsAsJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(params);
            System.out.println("请求参数: \n" + paramsAsJson);

            String responseBody = client.getItemList(params);

            System.out.println("【成功】服务器返回了成功响应 (这很意外!):");
            Object successJson = objectMapper.readValue(responseBody, Object.class);
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(successJson));

        } catch (IOException e) {
            System.out.println("【失败】正如预期，服务器返回了错误:");
            System.out.println(e.getMessage());
        }
    }
}
