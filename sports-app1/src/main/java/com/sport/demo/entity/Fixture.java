package com.sport.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fixtures")
@NoArgsConstructor
@Getter
@Setter
public class Fixture {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer teamAId;
	private Integer teamBId;
	private Date startDate;
	private Double duration;
	
	private Integer refereeId;
}
