package com.bluexiii.zenscaffold.config;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by bluexiii on 22/08/2017.
 */
@Profile("enable-hystrix")
@Configuration
@EnableHystrix
@EnableHystrixDashboard
public class HystrixConfiguration {
}