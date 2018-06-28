package com.demidov.cinema.web.controller;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.model.entities.User;
import com.demidov.cinema.impl.service.managemodel.UserService;
import com.demidov.cinema.web.controller.common.UserRequest;
import com.demidov.cinema.web.controller.common.UserResponse;
import com.demidov.cinema.web.controller.exceptions.CinemaWebRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/createuser", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public UserResponse createUser(@RequestBody UserRequest request) {
        try {
            User user = userService.createUser(request.getLogin(), request.getPassword());
            UserResponse response = new UserResponse();
            response.setValid(user != null);
            return response;
        } catch (CinemaProcessModelException e) {
            throw new CinemaWebRuntimeException(e);
        }
    }
}
