package com.toureasy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toureasy.dto.AuthRequest;
import com.toureasy.entity.Agent;
import com.toureasy.repositories.AgentRepository;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentRepository agentRepostiry;
	
	
	@Override
	public Agent loginAgent(AuthRequest authrequest) {
		return agentRepostiry.loginValidation(authrequest.getLoginId(), authrequest.getPassword());
		
	}

	@Override
	public Agent addAgent(Agent agent) {

		return agentRepostiry.save(agent);

	}

	@Override
	public Agent updateAgent(String id, Agent agent) {

		Agent existingAgent = agentRepostiry.findById(id).orElse(null);
		if (existingAgent != null) {
			existingAgent.setFirstName(agent.getFirstName());
			existingAgent.setLastName(agent.getLastName());
			existingAgent.setCompanyReg(agent.getLoginId());
			existingAgent.setMobileNo(agent.getMobileNo());
			existingAgent.setPassword(agent.getMobileNo());
			existingAgent.setCompanyName(agent.getCompanyReg());

			return agentRepostiry.save(existingAgent);

		} else {
			return null;
		}

	}

	@Override
	public void deleteAgent(String id) {
		agentRepostiry.deleteById(id);
	}

	@Override
	public Agent getAgent(String id) {
		return agentRepostiry.findById(id).orElse(null);
	}

	

}
