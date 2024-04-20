package com.sport.demo.dto.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import static com.sport.demo.util.Constants.*;

@Getter
@Setter
public class AddEventRequestDTO {
	@NotBlank(message = INVALID_EVENT_NAME_MSG)
	private String name;

	@NotBlank(message = INVALID_START_DATE_MSG)
	private String startDate;

	@NotBlank(message = INVALID_END_DATE_MSG)
	private String endDate;

	@NotNull(message = INVALID_ENTRY_FEES_MSG)
	private Double entryFees;
	private List<Integer> teamIds;
	private Integer venueId;
	private Integer sportId;
	private Integer refereeId;
	private Integer organizerId;
	
}
