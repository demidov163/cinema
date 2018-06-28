package com.demidov.cinema.impl.service.purchase;

import com.demidov.cinema.impl.exceptions.CinemaPurchaseProcessingException;
import com.demidov.cinema.impl.service.common.SessionPrices;

import java.util.Date;

public interface SessionPriceCalculationService {
    SessionPrices calculatePlacePricesBySession(Integer sessionId) throws CinemaPurchaseProcessingException;

    int calculateSessionPrice(Integer basePrice, Date sessionDate);
}
