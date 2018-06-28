package com.demidov.cinema.impl.service.managemodel;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.model.entities.Session;
import com.demidov.cinema.impl.model.entities.Ticket;

public interface TicketService {
    Ticket createTicket(Session session, Integer price, Integer placeRow, Integer placeColumn) throws CinemaProcessModelException;
}
