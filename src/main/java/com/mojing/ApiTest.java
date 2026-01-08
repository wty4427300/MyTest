package com.mojing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ApiTest {

    // --- Configuration ---
    private static final int PAGE_SIZE = 100;
    private static final String OUTPUT_FILENAME = "item_list_export.csv";
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY_MS = 2000;
    private static final long PAGE_DELAY_MS = 200;

    public static void main(String[] args) {
        ApiClient client = new ApiClient(getApiKey());
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("第一步: 获取 url_id...");
        String urlId = getUrlId(client);
        if (urlId == null) {
            System.out.println("获取 url_id 失败，程序终止。");
            return;
        }
        System.out.println("成功获取 url_id: " + urlId);

        System.out.println("\n第二步: 开始分页获取所有商品数据...");
        List<Map<String, Object>> allItems = new ArrayList<>();
        long totalStartTime = System.nanoTime();
        int currentPage = 1;
        Integer totalItemCount = null; // To store the total count from the first page response

        while (true) {
            int attempt = 0;
            boolean pageFetchedSuccessfully = false;
            long pageStartTime = System.nanoTime();

            while (attempt < MAX_RETRIES) {
                try {
                    System.out.printf("正在获取第 %d 页 (尝试 %d/%d)... ", currentPage, attempt + 1, MAX_RETRIES);
                    Map<String, Object> itemListParams = createItemListParams(urlId, currentPage);
                    String responseBody = client.getItemList(itemListParams);

                    Map<String, Object> responseMap = objectMapper.readValue(responseBody, new TypeReference<>() {});
                    Map<String, Object> resultMap = (Map<String, Object>) responseMap.get("result");

                    // On the first successful page fetch, get and print the total count
                    if (currentPage == 1 && resultMap.get("count") != null) {
                        totalItemCount = (Integer) resultMap.get("count");
                        System.out.print("API报告总条数: " + totalItemCount + ". ");
                    }

                    List<Map<String, Object>> items = (List<Map<String, Object>>) resultMap.get("data");

                    long pageEndTime = System.nanoTime();
                    long durationMs = TimeUnit.NANOSECONDS.toMillis(pageEndTime - pageStartTime);

                    if (items == null || items.isEmpty()) {
                        System.out.println("本页无数据，已获取所有商品。 耗时: " + durationMs + " ms");
                        allItems.add(Collections.emptyMap()); // Add a marker to stop the outer loop
                    } else {
                        allItems.addAll(items);
                        System.out.println("成功获取 " + items.size() + " 条数据。 耗时: " + durationMs + " ms");
                    }
                    pageFetchedSuccessfully = true;
                    break; // Exit retry loop on success

                } catch (IOException e) {
                    attempt++;
                    System.out.print("失败。错误: " + e.getMessage());
                    if (attempt < MAX_RETRIES) {
                        System.out.printf(",将在 %.1f 秒后重试...", RETRY_DELAY_MS / 1000.0);
                        try { Thread.sleep(RETRY_DELAY_MS); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
                    } else {
                        System.out.println(",已达最大重试次数，终止任务。");
                    }
                }
            }

            if (!pageFetchedSuccessfully || (allItems.size() > 0 && allItems.get(allItems.size() - 1).isEmpty())) {
                if(allItems.size() > 0 && allItems.get(allItems.size() - 1).isEmpty()) allItems.remove(allItems.size() - 1); // remove marker
                break; // Exit main loop
            }

            currentPage++;
            try { Thread.sleep(PAGE_DELAY_MS); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }

        long totalEndTime = System.nanoTime();
        long totalDurationSec = TimeUnit.NANOSECONDS.toSeconds(totalEndTime - totalStartTime);
        String countReport = (totalItemCount != null) ? "/" + totalItemCount : "";
        System.out.println("\n数据全部获取完毕。共获取 " + allItems.size() + countReport + " 条商品数据。总耗时: " + totalDurationSec + " 秒。");

        if (!allItems.isEmpty()) {
            System.out.println("\n第三步: 开始将数据写入 CSV 文件: " + OUTPUT_FILENAME);
            try {
                writeToCsv(allItems);
                System.out.println("CSV 文件写入成功！");
            } catch (IOException e) {
                System.out.println("CSV 文件写入失败！错误: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static String getApiKey() { return ""; }

    private static String getUrlId(ApiClient client) {
        Map<String, Object> uidParams = new HashMap<>();
        List<String> cids = Arrays.asList("201232201");
        uidParams.put("cid", Collections.singletonMap("not_custom", cids));
        List<Map<String, String>> catsList = new ArrayList<>();
        for (String id : cids) {
            Map<String, String> catMap = new HashMap<>();
            catMap.put("_id", id);
            catMap.put("fix_id", id);
            catMap.put("id", id);
            catsList.add(catMap);
        }
        uidParams.put("cats", catsList);
        uidParams.put("plat", "cshop,tmall");
        uidParams.put("time", Collections.singletonList(new String[]{"2025-07", "2025-07"}));

        try {
            return client.getUid(uidParams);
        } catch (IOException e) {
            System.err.println("获取 url_id 时出错: " + e.getMessage());
            return null;
        }
    }

    private static Map<String, Object> createItemListParams(String urlId, int page) {
        Map<String, Object> params = new HashMap<>();
        params.put("url_id", urlId);
        params.put("start", "2025-07");
        params.put("end", "2025-07");
        params.put("sku", "false");
        params.put("page", page);
        params.put("page_size", PAGE_SIZE);
        params.put("order_by", "sales");
        params.put("desc", "true");
        return params;
    }

    private static void writeToCsv(List<Map<String, Object>> items) throws IOException {
        if (items == null || items.isEmpty()) return;
        String[] headers = items.get(0).keySet().toArray(new String[0]);
        try (FileWriter out = new FileWriter(OUTPUT_FILENAME);
             CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(headers))) {
            for (Map<String, Object> item : items) {
                List<Object> values = new ArrayList<>();
                for (String header : headers) {
                    values.add(item.get(header));
                }
                printer.printRecord(values);
            }
        }
    }
}
