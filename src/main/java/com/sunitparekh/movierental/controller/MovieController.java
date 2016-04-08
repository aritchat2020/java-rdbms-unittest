package com.sunitparekh.movierental.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
