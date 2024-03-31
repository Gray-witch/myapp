package com.wuwi.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/ping")
    public String hello() {
        System.out.println("pong");
        return "Pong 123";
    }
}
