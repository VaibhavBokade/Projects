/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.example.sportsapp.entity;

import javax.persistence.*;

import java.util.Date;

/**
 * @author Tejas Nikhare
 * @version $Id: User.java, v 0.1 2023-02-27 17:25 Tejas Nikhare Exp $$
 */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String email;
    private String password;
    private Date dob;
    private String role;
}