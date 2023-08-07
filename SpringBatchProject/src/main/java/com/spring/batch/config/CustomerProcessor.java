package com.spring.batch.config;


import com.spring.batch.entity.Customer;

public class CustomerProcessor implements org.springframework.batch.item.ItemProcessor<Customer, Customer>{

	@Override
	public Customer process(Customer item) throws Exception {
		
		return item;
	}
	

}
