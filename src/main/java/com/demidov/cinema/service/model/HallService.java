package com.demidov.cinema.service.model;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.model.entities.Hall;

public interface HallService {
     void createHall(int hallNumber, int[][] places) throws CinemaProcessModelException;

     void deleteHall(Integer id);

     Hall getHallByHallNumber(Integer hallNumber);
}
