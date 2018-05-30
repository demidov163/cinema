package com.demidov.cinema.service.purchase;

import com.demidov.cinema.exceptions.CinemaPurchaseProcessingException;
import com.demidov.cinema.service.common.SessionPrice;

import java.util.Date;

public interface SessionPriceCalculationService {
    SessionPrice calculatePriceBySession(Integer sessionId) throws CinemaPurchaseProcessingException;

    int calculateSessionPrice(Integer basePrice, Date sessionDate);
}
