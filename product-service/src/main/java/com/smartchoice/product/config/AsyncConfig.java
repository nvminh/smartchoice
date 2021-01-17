package com.smartchoice.product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Value("${async.auditLogExecutor.corePoolSize}")
    private int corePoolSize;
    @Value("${async.auditLogExecutor.maxPoolSize}")
    private int maxPoolSize;
    @Value("${async.auditLogExecutor.queueCapacity}")
    private int queueCapacity;
    @Value("${async.auditLogExecutor.threadNamePrefix}")
    private String threadNamePrefix;

    @Bean(name = "auditLogExecutor")
    public Executor auditLogExecutor() {
        //return new ThreadPoolTaskExecutor();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.initialize();
        return executor;
    }
}
