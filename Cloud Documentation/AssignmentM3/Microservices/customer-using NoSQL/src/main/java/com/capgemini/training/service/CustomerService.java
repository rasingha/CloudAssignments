package com.capgemini.training.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.customer.entity.Customer;
import com.capgemini.training.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Transactional
	public void save(Customer cust) {

		customerRepository.save(cust);
	}

	@Transactional
	public void delete(Long id) {
		customerRepository.deleteById(id);
	}
	
	@Transactional
	public void update(Customer cust) {
		customerRepository.save(cust);
	}
	
	public List<Customer> getAllCustomer() {
		List<Customer> customer = new ArrayList<>();
		for (Customer cust : customerRepository.findAll()) {
			customer.add(cust);
		}
		return customer;
	}
	
	
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).get();
	}
}
