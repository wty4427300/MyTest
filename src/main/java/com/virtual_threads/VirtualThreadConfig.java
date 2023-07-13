//package com.virtual_threads;
//
//import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
//import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.AsyncTaskExecutor;
//import org.springframework.core.task.support.TaskExecutorAdapter;
//
//import java.util.concurrent.Executors;
//
//@Configuration
//public class VirtualThreadConfig {
//
//    @Bean(TaskExecutionAutoConfiguration.APPLICATION_TASK_EXECUTOR_BEAN_NAME)
//    public AsyncTaskExecutor asyncTaskExecutor() {
//        return new TaskExecutorAdapter(Executors.newVirtualThreadPerTaskExecutor());
//    }
//
//    /**
//     * 这个 Bean 是一个自定义的 Tomcat 协议处理器，负责处理 Spring Boot 应用程序中传入的请求。
//     * 这个自定义程序的目的是配置协议处理器使用的执行器。
//     */
//    @Bean
//    public TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer() {
//        return protocolHandler -> protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
//    }
//}
