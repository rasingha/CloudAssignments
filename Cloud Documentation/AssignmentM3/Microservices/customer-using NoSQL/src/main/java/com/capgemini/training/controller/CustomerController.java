package com.capgemini.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.customer.entity.Customer;
import com.capgemini.training.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}
	
	@PostMapping("/customers")
	public void createCustomer(@RequestBody Customer cust) {
		customerService.save(cust);
	}
	
	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer cust) {
		customerService.update(cust);
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.delete(id);
	}
}
