package com.toureasy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toureasy.dto.AuthRequest;
import com.toureasy.entity.Agent;
import com.toureasy.service.AgentService;

@RestController
@RequestMapping("/agent")
@CrossOrigin(origins = "http://localhost:3000")
public class AgentController {

	@Autowired
	private AgentService agentService;

	@PostMapping("/login")
	public ResponseEntity<Agent> loginAgentFromDb(@Valid @RequestBody AuthRequest authRequest) {
		Agent agent = agentService.loginAgent(authRequest);
		if (agent != null) {
			return new ResponseEntity<>(agent, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Agent> addAgent(@Valid @RequestBody Agent agent) {
		Agent addAgent = agentService.addAgent(agent);
		return new ResponseEntity<>(addAgent, HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Agent> getAgentById(@PathVariable("id") String id) {

		Agent existingAgent = agentService.getAgent(id);
		if (existingAgent != null) {
			return new ResponseEntity<>(existingAgent, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAdminById(@PathVariable("id") String id) {
		agentService.deleteAgent(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Agent> updateAdminFromDb(@PathVariable("id") String id, @Valid @RequestBody Agent agent) {
		Agent existingAgent = agentService.updateAgent(id, agent);
		if (existingAgent != null) {
			return new ResponseEntity<>(existingAgent, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
