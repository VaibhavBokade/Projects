/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.example.sportsapp.entity;

import javax.persistence.*;

import java.util.List;

/**
 * @author Tejas Nikhare
 * @version $Id: Team.java, v 0.1 2023-02-27 17:30 Tejas Nikhare Exp $$
 */
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer team_id;
    private String team_name;
    private String captain;
    private Integer noOfPlayers;
    private Integer matchesPlayed;

    @OneToMany(mappedBy = "team")//one team has many players
    private List<Player> players;

    @OneToMany(mappedBy = "team") //one team has many schedules
    private List<Schedule> schedules;

}