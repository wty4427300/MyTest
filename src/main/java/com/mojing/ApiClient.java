package com.mojing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApiClient {

    private static final String BASE_URL = "https://fenxiapi.mktindex.com/api/sub";
    private final String apiKey;
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Interface 1: Get URL ID
     *
     * @param params The request parameters for getting the url_id.
     * @return The url_id from the response.
     * @throws IOException If the request fails.
     */
    public String getUid(Map<String, Object> params) throws IOException {
        String jsonBody = objectMapper.writeValueAsString(params);
        RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-f"), jsonBody);

        Request request = new Request.Builder()
                .url(BASE_URL + "/get_uid")
                .header("MOOJING-APIKEY", apiKey)
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response + "\n" + response.body().string());
            }

            String responseBody = response.body().string();
            Map<String, Object> result = objectMapper.readValue(responseBody, Map.class);

            if ("ok".equals(result.get("status"))) {
                Map<String, Object> resultData = (Map<String, Object>) result.get("result");
                return (String) resultData.get("url_id");
            } else {
                throw new IOException("API returned an error: " + responseBody);
            }
        }
    }

    /**
     * Interface 2: Get Summary
     *
     * @param urlId The url_id obtained from getUid.
     * @param start The start date in YYYY-MM format.
     * @param end   The end date in YYYY-MM format.
     * @return The summary data as a JSON string.
     * @throws IOException If the request fails.
     */
    public String getSummary(String urlId, String start, String end) throws IOException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/summary").newBuilder()
                .addQueryParameter("url_id", urlId)
                .addQueryParameter("start", start)
                .addQueryParameter("end", end);

        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .header("MOOJING-APIKEY", apiKey)
                .get()
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response + "\n" + response.body().string());
            }
            return response.body().string();
        }
    }

    /**
     * Interface 9: Get Item List
     *
     * @param params The request parameters for getting the item list.
     * @return The item list data as a JSON string.
     * @throws IOException If the request fails.
     */
    public String getItemList(Map<String, Object> params) throws IOException {
        String jsonBody = objectMapper.writeValueAsString(params);
        RequestBody body = RequestBody.create(jsonBody, MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(BASE_URL + "/item_list")
                .header("MOOJING-APIKEY", apiKey)
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            String responseBody = response.body().string(); // Read body once to be able to reuse it
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response + "\n" + responseBody);
            }

            // Also check the logical status inside the JSON response
            Map<String, Object> responseMap = objectMapper.readValue(responseBody, new TypeReference<>() {});
            if (!"ok".equals(responseMap.get("status"))) {
                throw new IOException("API returned an error: " + responseBody);
            }

            return responseBody; // Return the full success response body
        }
    }
}
