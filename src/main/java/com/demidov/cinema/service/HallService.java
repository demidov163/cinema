package com.demidov.cinema.service;

import com.demidov.cinema.exceptions.CinemaProcessModelException;

public interface HallService {
     void createHall(String name, int[][] places) throws CinemaProcessModelException;
}
