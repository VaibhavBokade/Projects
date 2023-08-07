package com.airplane.service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String role;
    private int count;
    private Boolean isActive;
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;
    private Date dateTime;
}
