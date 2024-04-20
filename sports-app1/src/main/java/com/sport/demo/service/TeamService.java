package com.sport.demo.service;

import com.sport.demo.dto.request.AddTeamRequestDTO;
import com.sport.demo.dto.response.AddTeamResponseDTO;

public interface TeamService {
	AddTeamResponseDTO addTeam(AddTeamRequestDTO request);

}
