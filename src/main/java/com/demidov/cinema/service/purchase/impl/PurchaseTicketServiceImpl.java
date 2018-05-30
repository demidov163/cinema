package com.demidov.cinema.service.purchase.impl;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.exceptions.CinemaPurchaseProcessingException;
import com.demidov.cinema.model.entities.Session;
import com.demidov.cinema.model.entities.Ticket;
import com.demidov.cinema.service.common.Place;
import com.demidov.cinema.service.managemodel.SessionService;
import com.demidov.cinema.service.managemodel.TicketService;
import com.demidov.cinema.service.purchase.SessionPriceCalculationService;
import com.demidov.cinema.service.purchase.PurchaseTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseTicketServiceImpl implements PurchaseTicketService {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private TicketService ticketService;

    private SessionPriceCalculationService priceCalculator;


    @Override
    public List<Ticket> purchaseTickets(int sessionId, List<Place> places) throws CinemaPurchaseProcessingException {
        Optional<Session> session = sessionService.getSessionById(sessionId);
        if (!session.isPresent()) {
            throw new CinemaPurchaseProcessingException(String.format("No such session id - %d", sessionId));
        }

        Integer[][] hallPlaces = session.get().getHall().getPlaces();
        for (Place place : places) {
            int commonPrice = priceCalculator.calculatePriceBySession(sessionId, isVipPlace(hallPlaces, place));
            try {
                ticketService.createTicket(session.get(), commonPrice, place.getRow(), place.getColumn());
            } catch (CinemaProcessModelException e) {
                throw new CinemaPurchaseProcessingException(e);
            }
        }

        return null;
    }

    private boolean isVipPlace(Integer[][] hallPlaces, Place place) {
        // TODO: check row column place
        return hallPlaces[place.getRow()][place.getColumn()] == 1;
    }
}
