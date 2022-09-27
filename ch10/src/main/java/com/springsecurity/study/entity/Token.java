package com.springsecurity.study.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Token {

    @Id
    @GeneratedValue
    private int id;

    private String identifier;
    private String token;
}
