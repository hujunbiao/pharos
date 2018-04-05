package com.crick.business.pharos.config;

import com.crick.business.pharos.aop.AuthorInterceptor;
import com.crick.business.pharos.service.AlertTextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${wechat.cp.agentid}")
    private Integer agentid;

//    @Bean
//    public SignInterceptor signInterceptor(){
//        return new SignInterceptor();
//    }
    @Bean
    public AuthorInterceptor authorInterceptor(){
        return new AuthorInterceptor();
    }

//    @Bean
//    public PingCheckTask pingCheckTask(){
//        return new PingCheckTask();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(signInterceptor());
        registry.addInterceptor(authorInterceptor());
    }

    @Bean
    public AlertTextBuilder alertTextBuilder(){
        return new AlertTextBuilder(agentid);
    }
}
