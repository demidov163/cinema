package com.demidov.cinema.service.purchase;

import com.demidov.cinema.exceptions.CinemaPurchaseProcessingException;

public interface PurchaseService {
    Integer calculatePriceBySession(Integer sessionId,  boolean isVipPlace) throws CinemaPurchaseProcessingException;

}
