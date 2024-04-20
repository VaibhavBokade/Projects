package com.sport.demo.service;

import com.sport.demo.dto.request.AddSportRequestDTO;
import com.sport.demo.dto.response.AddSportResponseDTO;

public interface SportService {
	AddSportResponseDTO addSport(AddSportRequestDTO request);
}
