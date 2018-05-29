package com.demidov.cinema.service.purchase.impl;

import com.demidov.cinema.exceptions.CinemaPurchaseProcessingException;
import com.demidov.cinema.model.entities.Session;
import com.demidov.cinema.service.model.SessionService;
import com.demidov.cinema.service.purchase.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CommonPurchaseServiceImpl implements PurchaseService {

    @Autowired
    private SessionService sessionService;

    @Override
    public Integer calculatePriceBySession(Integer sessionId, boolean isVipPlace) throws CinemaPurchaseProcessingException {

        Optional<Session> sessionById = sessionService.getSessionById(sessionId);
        if (!sessionById.isPresent()) {
            throw new CinemaPurchaseProcessingException(String.format("Session id %d is not valid ", sessionId));
        }

        Session session = sessionById.get();

        Integer price = session.getPrice();
        if (isVipPlace) {
            price *= 15;
        }

        return price;
    }
}
