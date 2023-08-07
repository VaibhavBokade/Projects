package com.toureasy.service;

import com.toureasy.dto.AuthRequest;
import com.toureasy.entity.Customer;

public interface CustomerService {
	public Customer loginCustomer(AuthRequest authRequest);

	public Customer addCustomer(Customer customer);

	public void deleteCustomer(String id);

	public Customer getCustomer(String id);

	public Customer updateCustomer(String id, Customer customer);

}
