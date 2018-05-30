package com.demidov.cinema.service.purchase.impl;

import com.demidov.cinema.exceptions.CinemaPurchaseProcessingException;
import com.demidov.cinema.model.entities.Session;
import com.demidov.cinema.service.managemodel.SessionService;
import com.demidov.cinema.service.purchase.SessionPriceCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CommonCinemaPriceCalculationServiceImpl implements SessionPriceCalculationService {

    @Autowired
    private SessionService sessionService;

    @Override
    public int calculatePriceBySession(Integer sessionId, boolean isVipPlace) throws CinemaPurchaseProcessingException {
        Optional<Session> sessionById = sessionService.getSessionById(sessionId);
        if (!sessionById.isPresent()) {
            throw new CinemaPurchaseProcessingException(String.format("Session id %d is not valid ", sessionId));
        }

        Session session = sessionById.get();

        Integer price = session.getPrice();

        if (isVipPlace) {
            price = Math.round(price * session.getHall().getPlacecoeff());
        }

        return price;
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
