package com.demidov.cinema.model.repositories;

import com.demidov.cinema.model.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    List<Ticket> findBySession_Id(Integer Id);

    Ticket findByPlaceRowAndPlaceColumnAndSession_Id(Integer placeRow, Integer placeColumn, Integer Id);
}
