package com.sport.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "events")
@NoArgsConstructor
@Getter
@Setter
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Date startDate;
	private Date endDate;
	private Integer noOfTeams;
	private Double entryFees;
	
	@ManyToOne
	@JoinColumn(name = "organizer_id")
	private Organizer organizer;
	
	@OneToOne
	@JoinColumn(name = "sport_id", referencedColumnName = "id")
	private Sport sport; 
	
	@OneToMany(mappedBy = "event")
	private List<Schedule> schedules;
}
