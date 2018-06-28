package com.demidov.cinema.impl.service.managemodel.impl;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.model.entities.Session;
import com.demidov.cinema.impl.model.entities.Ticket;
import com.demidov.cinema.impl.model.repositories.TicketRepository;
import com.demidov.cinema.impl.service.managemodel.TicketService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ObjectFactory<Ticket> ticketFactory;

    @Override
    public Ticket createTicket(Session session, Integer price, Integer placeRow, Integer placeColumn) throws CinemaProcessModelException {
        Ticket ticketBySessionId = ticketRepository.findByPlaceRowAndPlaceColumnAndSession_Id(placeRow, placeColumn, session.getId());
        if (ticketBySessionId != null) {
            throw new CinemaProcessModelException(String.format("Ticket for %s film and place %d is sold",
                    session.getFilm().getName(), placeRow));
        }
        Ticket newTicket = ticketFactory.getObject();
        newTicket.setSession(session);
        newTicket.setPrice(price);
        newTicket.setPlaceRow(placeRow);
        newTicket.setPlaceColumn(placeColumn);

        // TODO: perform validation

        return ticketRepository.save(newTicket);
    }
}
