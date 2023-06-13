package com.concurrent.lock;

import java.util.Objects;

public class GuardedObjectDemo {

    public void send(String message){}


    /**
     * 处理请求
     */
    public String handleWebReq(){
        String message= "消息";
        send(message);
        GuardedObject<String> go=GuardedObject.create(message);
        return go.get(Objects::nonNull);
    }

    public void onMessage(String msg){
        //如何找到匹配的
        GuardedObject.fireEvent(msg,msg);
    }

}
