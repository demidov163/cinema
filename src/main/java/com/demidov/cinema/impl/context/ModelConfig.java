package com.demidov.cinema.impl.context;

import com.demidov.cinema.impl.model.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

    @Bean
    public Film getFilm() {
        return new Film();
    }

    @Bean
    public Hall getHall() {
         return new Hall();
    }

    @Bean
    public Session getSession() {
        return new Session();
    }

    @Bean
    public Ticket getTicket() {
        return new Ticket();
    }

    @Bean
    public User getUser() {
        return new User();
    }
}
