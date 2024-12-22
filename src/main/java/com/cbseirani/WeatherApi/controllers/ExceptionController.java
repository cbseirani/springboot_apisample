package com.cbseirani.weatherapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/not-valid")
    public String throwNotValid() {
        return "Hello, World!";
    }

    @GetMapping("/not-found")
    public String throwNotFound() {
        return "Hello, World!";
    }
}
