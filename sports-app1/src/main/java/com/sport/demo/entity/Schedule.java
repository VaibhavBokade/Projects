package com.sport.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "schedules")
@NoArgsConstructor
@Getter
@Setter
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "schedule_date")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	
//	@OneToOne
//	@JoinColumn(name = "result_id", referencedColumnName = "id")
//	private Result result;
	
}