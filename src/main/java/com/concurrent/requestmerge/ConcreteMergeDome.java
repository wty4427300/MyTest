package com.concurrent.requestmerge;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Data
class Test {
    private String a;
    private String b;
}

@Service
public class ConcreteMergeDome extends AbstractMergeService {

    @Override
    protected Object mergeAndExecuteRequests(List<Request> requests) {
        // 实现合并请求并批量执行的具体逻辑
        // 批处理的结果对象
        Test test = new Test();
        test.setA("123");
        test.setB("456");
        return test;
    }

    @Override
    protected void dispatchResultToFuture(Request request, Object result) {
        Test test = (Test) result;
        Map<String, Object> map = new HashMap<>();
        map.put("a", test.getA());
        map.put("b", test.getB());
        request.getFuture().complete(map);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConcreteMergeDome mergeDome=new ConcreteMergeDome();
        Object a = mergeDome.query("a");
        System.out.println(a);
        Object b = mergeDome.query("b");
        System.out.println(b);
    }
}
