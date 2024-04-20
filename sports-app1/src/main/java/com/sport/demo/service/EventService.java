package com.sport.demo.service;

import com.sport.demo.dto.request.AddEventRequestDTO;
import com.sport.demo.dto.response.AddEventResponseDTO;

public interface EventService {
	AddEventResponseDTO addEvent(AddEventRequestDTO request);
}
