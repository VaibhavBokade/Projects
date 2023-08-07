package com.crud.opr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.opr.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
