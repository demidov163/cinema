package com.demidov.cinema.model.factories;


import com.demidov.cinema.model.entities.Film;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

@Service
public class FilmFactory implements ObjectFactory<Film>{

    @Override
    public Film getObject() throws BeansException {
        return new Film();
    }
}
