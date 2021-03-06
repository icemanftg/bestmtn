package com.endava.test;

import com.endava.service.TimeService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ionuț Păduraru
 */
@Configuration("springConfig")
public class SpringConfig extends com.endava.spring.SpringConfig {

    @Bean
    public TimeService getTimeService() throws Exception {
        return Mockito.mock(TimeService.class);
    }

}
