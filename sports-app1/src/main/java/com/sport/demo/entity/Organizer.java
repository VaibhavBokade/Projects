package com.sport.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organizers")
@NoArgsConstructor
@Getter
@Setter
public class Organizer extends User{
	@OneToMany(mappedBy = "organizer")
	private List<Event> events;

	
}
