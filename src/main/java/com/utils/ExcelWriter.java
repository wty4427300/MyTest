package com.utils;

import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
@FunctionalInterface
interface DataProcessor<T> {
    void process(List<T> data);
}

public class ExcelWriter<T> {
    private final BasePage<T> basePage;
    private final BlockingQueue<List<T>> dataQueue = new LinkedBlockingQueue<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);
    @Setter
    private DataProcessor<T> customProcessor;

    public ExcelWriter(BasePage<T> basePage) {
        this.basePage = basePage;
    }

    public void processDataAndWriteToExcel() {
        producer();
        consumer();
        executorService.shutdown();
    }

    private void producer() {
        executorService.submit(() -> {
            try {
                int pageNos = basePage.getPageNos();
                int currPageNo = basePage.getCurrPageNo();

                while (currPageNo <= pageNos) {
                    List<T> pageData = this.fetchDataFromDatabase(currPageNo, basePage.getLimit());
                    dataQueue.put(pageData);
                    currPageNo++;
                }
                dataQueue.put(Collections.emptyList());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }


    private void consumer() {
        executorService.submit(() -> {
            try {
                while (true) {
                    List<T> pageData = dataQueue.take();
                    if (pageData.isEmpty()) {
                        break;
                    }
                    processAndWriteToExcel(pageData);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    private List<T> fetchDataFromDatabase(int pageNo, int pageSize) {
        int start = (pageNo - 1) * pageSize;
        int end = Math.min(start + pageSize, basePage.getDatas().size());
        return basePage.getDatas().subList(start, end);
    }

    private void processAndWriteToExcel(List<T> data) {
        // 用户自定义处理逻辑
        if (customProcessor != null) {
            customProcessor.process(data);
        }
    }


    public static void main(String[] args) {
        BasePage<Integer> page = new BasePage<>();
        ExcelWriter<Integer> excelWriter=new ExcelWriter<>(page);
        excelWriter.setCustomProcessor(data -> {
            List<String> collect = data.stream().map(Object::toString).toList();
        });
    }
}
