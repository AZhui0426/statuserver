package com.azhui.statuserver.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Yang Zhongwei
 * @date 2021/11/29
 */
@Configuration
@EnableAsync
@EnableConfigurationProperties(value = {TaskExecutorConfig.class})
public class ThreadPoolConfig {

    @Autowired
    private TaskExecutorConfig taskExecutorConfig;

    @Bean("taskExecutor")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(taskExecutorConfig.getCorePoolSize());
        executor.setMaxPoolSize(taskExecutorConfig.getMaxPoolSize());
        executor.setQueueCapacity(taskExecutorConfig.getQueueCapacity());
        executor.setKeepAliveSeconds(taskExecutorConfig.getKeepAliveSeconds());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("customer-thread-");
        return executor;
    }

    @Bean("lifeCycleExecutor")
    public ExecutorService lifeCycleExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(taskExecutorConfig.getCorePoolSize());
        executor.setMaxPoolSize(taskExecutorConfig.getMaxPoolSize());
        executor.setQueueCapacity(taskExecutorConfig.getQueueCapacity());
        executor.setKeepAliveSeconds(taskExecutorConfig.getKeepAliveSeconds());
        executor.setThreadNamePrefix("lifeCycle-thread-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 执行初始化
        executor.initialize();
        return executor.getThreadPoolExecutor();
    }
}
