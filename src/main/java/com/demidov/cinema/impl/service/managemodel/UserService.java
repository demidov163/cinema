package com.demidov.cinema.impl.service.managemodel;


import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.model.entities.User;

public interface UserService {
     User createUser(String name, String password) throws CinemaProcessModelException;
}
