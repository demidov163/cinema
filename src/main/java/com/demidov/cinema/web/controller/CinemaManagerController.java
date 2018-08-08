package com.demidov.cinema.web.controller;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.model.entities.Film;
import com.demidov.cinema.impl.model.entities.Hall;
import com.demidov.cinema.impl.model.entities.Session;
import com.demidov.cinema.impl.service.managemodel.FilmService;
import com.demidov.cinema.impl.service.managemodel.HallService;
import com.demidov.cinema.impl.service.managemodel.SessionService;
import com.demidov.cinema.impl.service.util.NumbersUtil;
import com.demidov.cinema.web.controller.common.*;
import com.demidov.cinema.web.controller.exceptions.CinemaWebRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class CinemaManagerController {

    @Autowired private HallService hallService;

    @Autowired private FilmService filmService;

    @Autowired private SessionService sessionService;

    @RequestMapping(value = "/halls/createhall", method = RequestMethod.POST)
    @ResponseBody
    public HallResponse createHall(@RequestBody HallRequest request) {
        try {
            Hall hall = hallService.createHall(request.getName(), request.getHallNumber(), NumbersUtil.matrixConvertToInt(request.getPlaces()));
            HallResponse hallResponse = new HallResponse();
            hallResponse.setId(hall.getId());
            return hallResponse;
        } catch (CinemaProcessModelException e) {
            throw new CinemaWebRuntimeException(e);
        }
    }

    @RequestMapping(value = "/films/createfilm", method = RequestMethod.POST)
    @ResponseBody
    public FilmResponse createFilm(@RequestBody FilmRequest request) {

        try {
            Film film = filmService.createFilm(request.getName(), request.getDurationMinutes(), request.getBasePrice());
            FilmResponse filmResponse = new FilmResponse();
            filmResponse.setId(film.getId());
            return filmResponse;
        } catch (CinemaProcessModelException e) {
            throw new CinemaWebRuntimeException(e);
        }
    }

    @RequestMapping(value = "/films/createsession", method = RequestMethod.POST)
    @ResponseBody
    public SessionResponse createSession(@RequestBody SessionRequest request) {
        try {
            Session session = sessionService.createSession(request.getFilmId(), request.getHallId(),
                    new Date(request.getSessionDateTs()));
            SessionResponse sessionResponse = new SessionResponse();
            sessionResponse.setId(session.getId());
            return sessionResponse;
        } catch (CinemaProcessModelException e) {
            throw new CinemaWebRuntimeException(e);
        }
    }
}
