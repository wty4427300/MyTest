package com.design_patterns.proxy.v2;

import com.design_patterns.proxy.v1.IUserController;
import com.design_patterns.proxy.v1.UserController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MetricsCollectorProxy {
    private final String str;

    public MetricsCollectorProxy() {
        this.str = "动态代理";
    }

    public Object createProxy(Object proxiedObject) {
        //获取实现了接口的所有类
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    private record DynamicProxyHandler(Object proxiedObject) implements InvocationHandler {
        private DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
            System.out.println("初始化代理类");
        }

        /**
         * @param proxy  被代理对象
         * @param method 表示被调用的方法对象
         * @param args   方法入參
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("执行代理方法");
            long startTimestamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            System.out.println(apiName + ":" + responseTime);
            return result;
        }
    }

    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        userController.login("小王", "123456");
    }
}
