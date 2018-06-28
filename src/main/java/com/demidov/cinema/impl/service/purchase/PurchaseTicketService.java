package com.demidov.cinema.impl.service.purchase;

import com.demidov.cinema.impl.exceptions.CinemaPurchaseProcessingException;
import com.demidov.cinema.impl.model.entities.Ticket;
import com.demidov.cinema.impl.service.common.Place;

import java.util.List;

public interface PurchaseTicketService {
     List<Ticket> purchaseTickets(Integer userId, int sessionId, List<Place> places) throws CinemaPurchaseProcessingException;
}
