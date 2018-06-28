package com.demidov.cinema.web.context;

import com.demidov.cinema.impl.context.AppConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@EnableWebMvc
@ComponentScan(basePackages = "com.demidov.cinema.web")
@Import(value = AppConfig.class)
public class WebConfig {

    @Bean
    public ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver() {
        ExceptionHandlerExceptionResolver a = new ExceptionHandlerExceptionResolver();
        a.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return a;
    }

}
