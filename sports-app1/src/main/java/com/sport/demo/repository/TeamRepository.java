package com.sport.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sport.demo.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
	
	Team findByName(String sportName);

}
