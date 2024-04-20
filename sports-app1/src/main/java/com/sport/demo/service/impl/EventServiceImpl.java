package com.sport.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.demo.dto.request.AddEventRequestDTO;
import com.sport.demo.dto.response.AddEventResponseDTO;
import com.sport.demo.entity.Event;
import com.sport.demo.exception.ResourceNotFoundException;
import com.sport.demo.repository.EventRepository;
import com.sport.demo.repository.TeamRepository;
import com.sport.demo.service.EventService;
import com.sport.demo.util.MapperUtil;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private EventRepository eventRepository;

	@Override
	public AddEventResponseDTO addEvent(AddEventRequestDTO request) {
		final List<Integer> list = request.getTeamIds();
		
		for(Integer id: list) {
			if(Optional.ofNullable(teamRepository.findById(id)).isEmpty()) {
				throw new ResourceNotFoundException("Team not found with id: "+id);
			}
		}
		
		final Event event = MapperUtil.toEventEntity(request);
		eventRepository.save(event);
		return new AddEventResponseDTO();
	}

}
