package com.springsecurity.study.controller;

import com.springsecurity.study.repository.JpaTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @GetMapping("/hello")
//    public String getHello() {
//        return "Get Hello!";
//    }
//
//    @PostMapping("/hello")
//    public String postHello() {
//        return "Post Hello!";
//    }

    @Autowired
    private JpaTokenRepository jpaTokenRepository;

    @GetMapping("/hello")
    public String getHello() {
        jpaTokenRepository.findAll();
        return "Get Hello!";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "Post Hello!";
    }

    @PostMapping("/ciao")
    public String postCiao() {
        return "Post Ciao";
    }
}
