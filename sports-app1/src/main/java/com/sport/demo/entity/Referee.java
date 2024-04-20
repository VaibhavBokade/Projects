package com.sport.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sport.demo.enums.AvailabilityStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "referees")
@NoArgsConstructor
@Getter
@Setter
public class Referee extends User{
	private AvailabilityStatus avlStatus;
	
}
