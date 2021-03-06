package com.endava.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.endava.datacontainer.DataContainer;
import com.endava.datacontainer.TvRageInfoContainerImpl;

/**
 * BEST Engineering Marathon 2014
 * Endava Federated Search, Returning(Callback) System
 *
 * @author <a href="mailto:alexandru.burghelea@endava.com">Alexandru BURGHELEA</a>
 * @since 3/13/14
 */
@SuppressWarnings("SpringFacetCodeInspection")
@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfiguration {

    @Value("${taskexecutor.corepoolsize}")
    private int corePoolSize;
    @Value("${taskexecutor.maxpoolsize}")
    private int maxPoolSize;
    @Value("${taskexecutor.shutdownwait}")
    private boolean waitForJobsToCompleteOnShutdown;

    Logger logger = LoggerFactory.getLogger(SpringConfiguration.class);

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(waitForJobsToCompleteOnShutdown);

        return taskExecutor;
    }

    @Bean
    public DataContainer dataContainer() {
        return new TvRageInfoContainerImpl("tvrage.json");
    }


}
