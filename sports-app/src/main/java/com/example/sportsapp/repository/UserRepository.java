/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.example.sportsapp.repository;

import com.example.sportsapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tejas Nikhare
 * @version $Id: UserRepository.java, v 0.1 2023-02-27 17:49 Tejas Nikhare Exp $$
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}