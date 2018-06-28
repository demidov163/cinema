package com.demidov.cinema.impl.service.managemodel;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.model.entities.Hall;

public interface HallService {
     Hall createHall(String name, int hallNumber, int[][] places) throws CinemaProcessModelException;

     void deleteHall(Integer id);

     Hall getHallByHallNumber(Integer hallNumber);
}
