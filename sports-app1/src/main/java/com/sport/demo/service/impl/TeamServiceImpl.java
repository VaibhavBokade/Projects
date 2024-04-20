package com.sport.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.demo.dto.request.AddTeamRequestDTO;
import com.sport.demo.dto.response.AddTeamResponseDTO;
import com.sport.demo.entity.Player;
import com.sport.demo.entity.Sport;
import com.sport.demo.entity.Team;
import com.sport.demo.exception.ResourceNotFoundException;
import com.sport.demo.exception.TeamAlreadyExistException;
import com.sport.demo.repository.PlayerRepository;
import com.sport.demo.repository.SportRepository;
import com.sport.demo.repository.TeamRepository;
import com.sport.demo.service.TeamService;
import com.sport.demo.util.MapperUtil;

@Service
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private SportRepository sportRepository;

	@Override
	public AddTeamResponseDTO addTeam(AddTeamRequestDTO request) {
		final Team team = MapperUtil.toTeamEntity(request);
		final String teamName = request.getName();
		final Integer sportId = request.getSportId();
		if(Optional.ofNullable(teamRepository.findByName(teamName)).isPresent()) {
			throw new TeamAlreadyExistException("Team already exist with team name: "+teamName);
		}
		request.getPlayerIds().forEach(playerId ->{
			Player player = playerRepository.findById(playerId).orElseThrow(() ->  new ResourceNotFoundException("Player not found with player id: "+playerId));
			team.getPlayers().add(player);
		});
		final Sport sport = sportRepository.findById(sportId).orElseThrow(() -> new ResourceNotFoundException("Sport not found with id: "+sportId));
		team.setSport(sport);
		teamRepository.save(team);
		return new AddTeamResponseDTO();
	}
}
