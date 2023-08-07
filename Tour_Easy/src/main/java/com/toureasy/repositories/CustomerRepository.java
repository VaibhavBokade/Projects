package com.toureasy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toureasy.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	@Query("select c from Customer c where c.loginId = :loginId and c.password = :password")
	public Customer validateCustomer(String loginId, String password);
	
	//@Query("select a from Agent a where a.loginId =: loginId and a.password =: password")
}
