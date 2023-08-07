package com.toureasy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toureasy.dto.AuthRequest;
import com.toureasy.entity.Customer;
import com.toureasy.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer loginCustomer(AuthRequest authRequest) {

		return customerRepository.validateCustomer(authRequest.getLoginId(), authRequest.getPassword());
	}

	@Override
	public Customer addCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(String id) {
		customerRepository.deleteById(id);

	}

	@Override
	public Customer getCustomer(String id) {

		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public Customer updateCustomer(String id, Customer customer) {
		Customer existingCustomer = customerRepository.findById(id).orElse(null);
		if (existingCustomer != null) {
			existingCustomer.setFirstName(customer.getFirstName());
			existingCustomer.setLastName(customer.getLastName());
			existingCustomer.setMobileNo(customer.getMobileNo());
			existingCustomer.setPassword(customer.getPassword());

			return customerRepository.save(existingCustomer);
		} else {
			return null;
		}
	}

}
