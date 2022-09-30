package com.springsecurity.study.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/helloName")
    public String hello(Authentication a) {
        return "Hello, " + a.getName() + "!";
    }
}
