package com.demidov.cinema.model.repositories;


import com.demidov.cinema.model.entities.Hall;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HallRepository extends CrudRepository<Hall, Integer> {
      List<Hall> findByNameIgnoreCase(String name);

      Hall findByHallNumber(Integer hallNumber);
}
