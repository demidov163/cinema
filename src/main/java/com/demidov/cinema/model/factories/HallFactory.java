package com.demidov.cinema.model.factories;


import com.demidov.cinema.model.entities.Hall;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

@Service
public class HallFactory implements ObjectFactory<Hall> {

    @Override
    public Hall getObject() throws BeansException {
        return new Hall();
    }
}
