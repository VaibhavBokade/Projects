package com.sport.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.sport.demo.enums.Role;
import com.sport.demo.enums.UserStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String firstName;
	private String lastName;
    private String username;
    private String password;
    private Role role;
    private Long contactNo;
    private UserStatus userStatus;
    
}