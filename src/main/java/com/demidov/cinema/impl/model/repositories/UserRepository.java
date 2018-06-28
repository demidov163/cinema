package com.demidov.cinema.impl.model.repositories;


import com.demidov.cinema.impl.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLoginIgnoreCase(String login);
}
