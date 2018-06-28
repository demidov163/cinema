package com.demidov.cinema.test.context;

import com.demidov.cinema.impl.context.AppConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = "com.demidov.cinema.test")
@Import(value = AppConfig.class)
public class TestConfig {

}
