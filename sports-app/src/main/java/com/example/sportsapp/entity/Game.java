/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.example.sportsapp.entity;

import javax.persistence.*;

/**
 * @author Tejas Nikhare
 * @version $Id: Game.java, v 0.1 2023-02-27 17:33 Tejas Nikhare Exp $$
 */
@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer game_id;
    private String game_type;
    private String game_name;
}