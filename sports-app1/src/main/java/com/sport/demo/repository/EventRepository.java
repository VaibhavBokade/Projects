package com.sport.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sport.demo.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{

//TODO
}
