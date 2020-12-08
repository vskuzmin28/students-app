package com.students.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.students.dto.AuthenticationStatus;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public AuthenticationStatus user() {
        return new AuthenticationStatus("Success");
    }

}
