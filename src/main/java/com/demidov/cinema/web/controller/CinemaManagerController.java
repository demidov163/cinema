package com.demidov.cinema.web.controller;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.model.entities.Hall;
import com.demidov.cinema.impl.service.managemodel.HallService;
import com.demidov.cinema.impl.service.util.NumbersUtil;
import com.demidov.cinema.web.controller.common.HallRequest;
import com.demidov.cinema.web.controller.common.HallResponse;
import com.demidov.cinema.web.controller.exceptions.CinemaWebRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaManagerController {

    @Autowired
    private HallService hallService;

    @RequestMapping(value = "/halls/createhall", method = RequestMethod.POST)
    @ResponseBody
    public HallResponse createHall(@RequestBody HallRequest request) {
        try {
            Hall hall = hallService.createHall(request.getName(), request.getHallNumber(), NumbersUtil.matrixConvertToInt(request.getPlaces()));
            HallResponse hallResponse = new HallResponse();
            hallResponse.setSuccess(hall != null);
            return hallResponse;
        } catch (CinemaProcessModelException e) {
            throw new CinemaWebRuntimeException(e);
        }
    }
}