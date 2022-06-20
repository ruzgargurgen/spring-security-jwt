package com.rgurgen.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgurgen.springsecurity.service.UserService;

@RestController
@RequestMapping("api/internal")//pre-path
public class InternalApiController
{
    @Autowired
    private UserService userService;

    @PutMapping("make-admin/{username}") //api/internal/make-admin/{username}
    public ResponseEntity<?> makeAdmin(@PathVariable String userName)
    {
        userService.makeAdmin(userName);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
