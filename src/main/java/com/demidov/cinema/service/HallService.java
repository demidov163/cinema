package com.demidov.cinema.service;

import com.demidov.cinema.exceptions.CinemaProcessModelException;

public interface HallService {
     void createHall(int hallNumber, int[][] places) throws CinemaProcessModelException;
}
