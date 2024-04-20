package com.sport.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.demo.dto.request.AddSportRequestDTO;
import com.sport.demo.dto.response.AddSportResponseDTO;
import com.sport.demo.entity.Sport;
import com.sport.demo.exception.SportAlreadyExistException;
import com.sport.demo.repository.SportRepository;
import com.sport.demo.service.SportService;
import com.sport.demo.util.MapperUtil;

@Service
public class SportServiceImpl implements SportService{
	
	@Autowired
	private SportRepository sportRepository;
	
	public AddSportResponseDTO addSport(AddSportRequestDTO request) {
		final Sport sport = MapperUtil.toSportEntity(request);
		final String sportName = request.getName();
		if(Optional.ofNullable(sportRepository.findByName(sport.getName())).isPresent()) {
			throw new SportAlreadyExistException("Sport already exist with sport name: "+sportName);
		}
		
		sportRepository.save(sport);
		return new AddSportResponseDTO();
	}
		
}
