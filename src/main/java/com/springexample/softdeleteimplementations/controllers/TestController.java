package com.springexample.softdeleteimplementations.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping
    public String home() {
        return "This is home!";
    }

    @GetMapping("/test")
    public String test() {
        return "Test API";
    }
}
