package com.zetta.springexperiments.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Value("${display-name: something else} ")
    private String displayName;
    @Value("${greeting}")
    private String greeting;


    @GetMapping("/name")
    public String getDisplayName() {
        return displayName;
    }

    @GetMapping("/greeting")
    public String getGreeting() {
        return greeting;
    }

}
