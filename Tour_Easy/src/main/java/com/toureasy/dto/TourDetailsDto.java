package com.toureasy.dto;

import java.time.LocalDate;

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
public class TourDetailsDto {
	
	private String source;
	private String destination;
	private String price;
	private LocalDate date;
	private String companyName;
	private String firstName;
	private String lastName;
	private String mobileNo;

}
