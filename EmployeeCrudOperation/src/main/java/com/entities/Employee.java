package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empid;
	
	//@Column(name = "emp_name")
	private String emp_name;
	
	//@Column(name = "emp_salary")
	private Float emp_salary;
	
	//@Column(name = "emp_age")
	private int emp_age;
	
	//@Column(name = "emp_city")
	private String emp_city;
	
	
}
