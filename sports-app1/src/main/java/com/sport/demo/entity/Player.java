package com.sport.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sport.demo.enums.Gender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "players")
@NoArgsConstructor
@Getter
@Setter
public class Player extends User {
	private Date dob;
	private Gender gender;
			
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
}