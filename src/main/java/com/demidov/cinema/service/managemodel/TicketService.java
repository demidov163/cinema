package com.demidov.cinema.service.managemodel;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.model.entities.Session;
import com.demidov.cinema.model.entities.Ticket;

public interface TicketService {
    Ticket createTicket(Session session, Integer price, Integer placeRow, Integer placeColumn) throws CinemaProcessModelException;
}
