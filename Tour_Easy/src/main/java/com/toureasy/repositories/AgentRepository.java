package com.toureasy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toureasy.entity.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, String> {

	@Query("select a from Agent a where a.loginId = :loginId and a.password = :password")
	Agent loginValidation(String loginId, String password);

}
//@Query("select c from Admin c where c.loginId = :loginId and c.password = :password")
//Admin loginValidation(String loginId, String password);
