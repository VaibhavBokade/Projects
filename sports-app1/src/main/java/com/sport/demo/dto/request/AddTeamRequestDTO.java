
package com.sport.demo.dto.request;
import static com.sport.demo.util.Constants.INVALID_TEAM_NAME_MSG;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTeamRequestDTO {
	@NotBlank(message = INVALID_TEAM_NAME_MSG)
	private String name;

	@NotNull(message = "Sport id cannot be null!")
	private Integer sportId;

	@NotNull(message = "Player id cannot be null!")
	private List<Integer> playerIds;

}
