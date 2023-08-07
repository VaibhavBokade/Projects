/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.example.sportsapp.entity;

import javax.persistence.*;

/**
 * @author Tejas Nikhare
 * @version $Id: Result.java, v 0.1 2023-02-27 17:34 Tejas Nikhare Exp $$
 */
@Entity
@Table(name = "results")
public class Result {
    @Id
    private Integer id;
    private Integer position;
    private Double score;

    @OneToOne
    @MapsId
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

}