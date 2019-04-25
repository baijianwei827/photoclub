package com.photo.api.config;

import com.photo.api.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器并指定拦截路径
       registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/v1/user/token/*/**");
       WebMvcConfigurer.super.addInterceptors(registry);
    }
}
