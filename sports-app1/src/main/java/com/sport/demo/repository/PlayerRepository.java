package com.sport.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sport.demo.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
