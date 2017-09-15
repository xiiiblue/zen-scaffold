package com.bluexiii.zenscaffold.config;

import com.bluexiii.zenscaffold.handler.LoggingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bluexiii on 16/9/5.
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    @Value("${custom.baseurl}")
    private String baseUrl;

    /**
     * Filter日志
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean getDemoFilter() {
        LoggingFilter loggingFilter = new LoggingFilter();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(loggingFilter);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add(baseUrl + "/*");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
