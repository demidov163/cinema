package com.demidov.cinema.service.model;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.model.entities.Session;

public interface TicketService {
    void createTicket(Session session, Integer price, Integer place) throws CinemaProcessModelException;
}
