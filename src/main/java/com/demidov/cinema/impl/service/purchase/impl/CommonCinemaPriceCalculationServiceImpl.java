package com.demidov.cinema.impl.service.purchase.impl;

import com.demidov.cinema.impl.exceptions.CinemaPurchaseProcessingException;
import com.demidov.cinema.impl.model.entities.Session;
import com.demidov.cinema.impl.service.common.SessionPrices;
import com.demidov.cinema.impl.service.managemodel.SessionService;
import com.demidov.cinema.impl.service.purchase.SessionPriceCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CommonCinemaPriceCalculationServiceImpl implements SessionPriceCalculationService {

    @Autowired
    private SessionService sessionService;

    @Override
    public SessionPrices calculatePlacePricesBySession(Integer sessionId) throws CinemaPurchaseProcessingException {
        Optional<Session> sessionById = sessionService.getSessionById(sessionId);
        if (!sessionById.isPresent()) {
            throw new CinemaPurchaseProcessingException(String.format("Session id %d is not valid ", sessionId));
        }

        Session session = sessionById.get();

        Integer price = session.getPrice();

        SessionPrices sessionPrice = new SessionPrices();
        sessionPrice.setSimplePlacePrice(price);
        sessionPrice.setVipPlacePrice(Math.round(price * session.getHall().getPlacecoeff()));
        return sessionPrice;
    }

    @Override
    public int calculateSessionPrice(Integer basePrice, Date sessionDate) {
        if (isHoliday(sessionDate)) {
            return Math.round((float) (basePrice * 1.2)); // TODO: use correct coefficient
        }
        return basePrice;
    }

    private boolean isHoliday(Date sessionDate) {
        return false;  // TODO: use joda time
    }
}
