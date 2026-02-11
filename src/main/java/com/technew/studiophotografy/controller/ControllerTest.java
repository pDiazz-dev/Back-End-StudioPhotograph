package com.technew.studiophotografy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/test")
public class ControllerTest {

    @GetMapping("/admin")
    public String test(){
        return "somente admin";
    }

    @PostMapping("/oi")
    public String login(){
        return "somente autenticado";
    }

}
