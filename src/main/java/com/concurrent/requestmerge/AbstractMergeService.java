package com.concurrent.requestmerge;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 请求合并
 */
@Service
public abstract class AbstractMergeService {

    //存放在配置中心
    private boolean needMerge;

    private LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    public Object query(String code) throws ExecutionException, InterruptedException {
        if (needMerge) {
            Request request = new Request(code, new CompletableFuture<>());
            queue.add(request);
            return request.getFuture().get();
        } else {
            return null;
        }
    }

    // 模板方法1：合并请求并执行的抽象方法
    protected abstract Object mergeAndExecuteRequests(List<Request> requests);

    // 模板方法2：分发结果到各个CompletableFuture的抽象方法
    protected abstract void dispatchResultToFuture(Request request, Object result);

    @PostConstruct
    public void init() {
        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(1);
        pool.scheduleAtFixedRate(() -> {
            if (queue.isEmpty()) {
                return;
            }
            //获取queue中的所有请求
            List<Request> list = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                Request request = queue.poll();
                list.add(request);
            }
            //模拟板方法1：合并请求，批量执行
            Object obj = mergeAndExecuteRequests(list);
            //模板方法2：分发请求给不同的future
            for (Request request : list) {
                dispatchResultToFuture(request, obj);
            }
        }, 0, 200, TimeUnit.MILLISECONDS);
    }

}
