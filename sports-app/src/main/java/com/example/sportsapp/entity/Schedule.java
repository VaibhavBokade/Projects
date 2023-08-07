/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.example.sportsapp.entity;

import javax.persistence.*;

import java.util.Date;

/**
 * @author Tejas Nikhare
 * @version $Id: Schedule.java, v 0.1 2023-02-27 17:35 Tejas Nikhare Exp $$
 */
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schedule_id;
    private Date timestamp;
    private String venue;
    //time addition req.????
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne(mappedBy = "schedule")//one schedule has one result
    @PrimaryKeyJoinColumn
    private Result result;



}