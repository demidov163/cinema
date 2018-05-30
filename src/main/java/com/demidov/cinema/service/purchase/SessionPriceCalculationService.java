package com.demidov.cinema.service.purchase;

import com.demidov.cinema.exceptions.CinemaPurchaseProcessingException;

import java.util.Date;

public interface SessionPriceCalculationService {
    int calculatePriceBySession(Integer sessionId,  boolean isVipPlace) throws CinemaPurchaseProcessingException;

    int calculateSessionPrice(Integer basePrice, Date sessionDate);
}
