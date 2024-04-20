package com.sport.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sport.demo.enums.ResultStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "results")
@NoArgsConstructor
@Getter
@Setter
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double score;
	private ResultStatus status;

//	@OneToOne(mappedBy = "result")
//	private Schedule schedule;

}