package com.toureasy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
	@Email
	private String loginId;

	private String password;

	private String mobileNo;

	private String firstName;

	private String lastName;

}
