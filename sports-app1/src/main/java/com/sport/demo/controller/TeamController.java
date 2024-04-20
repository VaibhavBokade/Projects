package com.sport.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.demo.dto.request.AddTeamRequestDTO;
import com.sport.demo.dto.response.AddTeamResponseDTO;
import com.sport.demo.service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {
	@Autowired
	private TeamService teamService;

	@PostMapping
	public ResponseEntity<AddTeamResponseDTO> addTeam(@Valid @RequestBody AddTeamRequestDTO request){
		return ResponseEntity.ok(teamService.addTeam(request));
	}
}
