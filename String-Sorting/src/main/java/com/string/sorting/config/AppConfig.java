package com.string.sorting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import com.string.sorting.service.AppService;
import com.string.sorting.service.AppServiceImpl;

/**
 * Created by Vineetha on 18/07/2017.
 * Spring configuration class to initialize service bean
 */
@Configuration
public class AppConfig {

    /**
     * To get service bean
     * @return AppService
     */
    @Bean(name="appService")
    @Description("Bean declaration for AppService")
    public AppService getAppService() {
        return new AppServiceImpl();
    }
 
}