package com.toureasy.service;

import com.toureasy.dto.AuthRequest;
import com.toureasy.entity.Agent;

public interface AgentService {

	public Agent loginAgent(AuthRequest authrequest);

	public Agent addAgent(Agent agent);

	public Agent updateAgent(String id, Agent agent);

	public void deleteAgent(String id);

	public Agent getAgent(String id);

}
