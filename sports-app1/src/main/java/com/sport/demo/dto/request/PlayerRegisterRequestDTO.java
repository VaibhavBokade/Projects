package com.sport.demo.dto.request;

import static com.sport.demo.util.Constants.INVALID_DOB_MSG;
import static com.sport.demo.util.Constants.INVALID_GENDER_MSG;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerRegisterRequestDTO extends RegisterRequestDTO{
	@NotBlank(message = INVALID_DOB_MSG)
	private String dob;
	
	@NotBlank(message = INVALID_GENDER_MSG)
	private String gender;
	
	@NotNull(message = "Team id cannot be null!")
	private Integer teamId;
}
