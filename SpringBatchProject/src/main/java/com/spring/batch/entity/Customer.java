package com.spring.batch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "CUSTOMER_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
    @Column(name="CUSTOMER_ID")
	private int id;
    @Column(name="FIRST_NAME")
	private String firstName;
    @Column(name="LAST_NAME")
	private String lastName;
    @Column(name="EMAIL")
	private String mail;
    @Column(name="GENDER")
	private String gender;
    @Column(name="CONTACT")
	private String contactNo;
    @Column(name="COUNTRY")
	private String country;
    @Column(name="DOB")
	private String dob;
	

}
