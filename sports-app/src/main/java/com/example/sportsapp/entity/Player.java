/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.example.sportsapp.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Tejas Nikhare
 * @version $Id: Player.java, v 0.1 2023-02-27 17:27 Tejas Nikhare Exp $$
 */
@Entity
@Table(name = "players")
public class Player extends User {
    private String name;
    private Double age;
    private Integer gamePlayed;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}