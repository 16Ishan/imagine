package com.imagine.book.controller;

import com.imagine.book.services.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController
{
    @Autowired
    private UsersService usersService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestParam String firstName,
                                               @RequestParam String lastName,
                                               @RequestParam String username,
                                               @RequestParam String password)
    {
        try
        {
            return new ResponseEntity<>(usersService.register(firstName, lastName,
                    username, password), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password)
    {
        try
        {
            return new ResponseEntity<>(usersService.login(username, password), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/logout")
    public ResponseEntity<String> logout()
    {
        try
        {
            return new ResponseEntity<>(usersService.logout(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
