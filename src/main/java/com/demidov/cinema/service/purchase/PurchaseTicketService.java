package com.demidov.cinema.service.purchase;

import com.demidov.cinema.exceptions.CinemaPurchaseProcessingException;
import com.demidov.cinema.model.entities.Ticket;
import com.demidov.cinema.service.common.Place;

import java.util.List;

public interface PurchaseTicketService {
     List<Ticket> purchaseTickets(int sessionId, List<Place> places) throws CinemaPurchaseProcessingException;
}
