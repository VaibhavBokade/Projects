package com.empRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {

}
