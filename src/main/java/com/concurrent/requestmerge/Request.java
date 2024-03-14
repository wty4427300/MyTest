package com.concurrent.requestmerge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    String code;
    CompletableFuture<Map<String, Object>> future;
}
