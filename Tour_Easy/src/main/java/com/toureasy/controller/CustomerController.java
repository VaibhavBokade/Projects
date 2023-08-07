package com.toureasy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toureasy.dto.AuthRequest;
import com.toureasy.entity.Customer;
import com.toureasy.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/login")
	public ResponseEntity<Customer> loginCustomerFromDb(@Valid @RequestBody AuthRequest authRequest) {
		Customer customer = customerService.loginCustomer(authRequest);
		if (customer != null) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

	}

	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		Customer newCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
		Customer existingCustomer = customerService.getCustomer(id);
		if (existingCustomer != null) {
			return new ResponseEntity<>(existingCustomer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") String id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomerFromDb(@PathVariable("id") String id,
			@Valid @RequestBody Customer customer) {

		Customer getCustomer = customerService.updateCustomer(id, customer);
		if (getCustomer != null) {
			return new ResponseEntity<>(getCustomer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
