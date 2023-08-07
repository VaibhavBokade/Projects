package com.jpa.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
