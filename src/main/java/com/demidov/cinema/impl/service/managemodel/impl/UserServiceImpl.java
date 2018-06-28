package com.demidov.cinema.impl.service.managemodel.impl;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.model.entities.User;
import com.demidov.cinema.impl.model.repositories.UserRepository;
import com.demidov.cinema.impl.service.managemodel.UserService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectFactory<User> userFactory;

    @Override
    public User createUser(String login, String password) throws CinemaProcessModelException {
        User userInRepository = userRepository.findByLoginIgnoreCase(login);
        if (userInRepository != null) {
            throw new CinemaProcessModelException(String.format("User with login %s has already registered in the system", login));
        }
        //TODO add validations

        User newUser = userFactory.getObject();
        newUser.setLogin(login);
        newUser.setPassword(password);

        return userRepository.save(newUser);
    }
}
