package com.demidov.cinema.model.factories;

import com.demidov.cinema.model.entities.Session;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

@Service
public class SessionFactory implements ObjectFactory<Session> {

    @Override
    public Session getObject() throws BeansException {
        return new Session();
    }
}
