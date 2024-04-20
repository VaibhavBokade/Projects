package com.sport.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teams")
@NoArgsConstructor
@Getter
@Setter
public class Team {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private Integer matchesPlayed;
	private Integer matchesWon;
	private Integer matchesTied;


	public Team(String name) {
		this.name = name;
		players = new ArrayList<>();
	}

	@OneToMany(mappedBy = "team")
	private List<Player> players;

	@OneToMany(mappedBy = "team")
	private List<Schedule> schedules;

	@OneToOne
	@JoinColumn(name = "sport_id")
	private Sport sport;

	@ManyToMany
	@JoinTable(name = "event_team", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> events;
}