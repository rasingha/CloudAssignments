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
import com.capgemini.training.exception.UserNotFoundException;
import com.capgemini.training.service.CustomerService;


@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		List<Customer> list= customerService.getAllCustomer();
		if(list.isEmpty()) {
			throw new UserNotFoundException(" No Customer Records Exist!! ");
		}
		return list;
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		
		Customer  user = customerService.getCustomer(id);
	    if( user == null)
	    {
	    	throw new UserNotFoundException(" User Not Found ");
	    }
	    
	    return user;
	}
	
	@PostMapping("/customers")
	public void createCustomer(@RequestBody Customer cust) {
		customerService.save(cust);
	}
	
	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer cust) {
		customerService.update(cust);
	}
	
	@DeleteMapping("/customers")
	public void deleteAllCustomer() {
		customerService.deleteAll();
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.delete(id);
	}
}
