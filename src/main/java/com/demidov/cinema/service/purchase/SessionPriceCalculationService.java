package com.demidov.cinema.service.purchase;

import com.demidov.cinema.exceptions.CinemaPurchaseProcessingException;
import com.demidov.cinema.service.common.SessionPrices;

import java.util.Date;

public interface SessionPriceCalculationService {
    SessionPrices calculatePlacePricesBySession(Integer sessionId) throws CinemaPurchaseProcessingException;

    int calculateSessionPrice(Integer basePrice, Date sessionDate);
}
