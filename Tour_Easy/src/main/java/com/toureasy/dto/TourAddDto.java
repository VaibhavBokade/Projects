package com.toureasy.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TourAddDto {

	private String source;

	private String destination;

	private String price;

	private LocalDate dateTime;

	private String loginId;

}
