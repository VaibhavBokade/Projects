package com.sport.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.demo.dto.request.AddEventRequestDTO;
import com.sport.demo.dto.response.AddEventResponseDTO;
import com.sport.demo.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	@Autowired
	private EventService eventService; 

	@PostMapping("/addevents")
	public ResponseEntity<AddEventResponseDTO> addEvent(@Valid @RequestBody AddEventRequestDTO request){
		return ResponseEntity.ok(eventService.addEvent(request));
	}
}

