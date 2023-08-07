package com.toureasy.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tour {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tourId;
	
	private String source;
	
	private String destination;
	
	private String price;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateTime;
	
	@ManyToOne
	@JoinColumn(name = "loginId")
	private Agent agent;

}
