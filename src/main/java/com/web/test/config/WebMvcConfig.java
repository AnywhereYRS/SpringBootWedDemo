package com.web.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by YRS on 2017/10/13.
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/toLoginForm").setViewName("loginForm");
        registry.addViewController("/user/toRegistForm").setViewName("registForm");
    }
}
