package com.capgemini.training.commandrunner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.capgemini.training.customer.entity.Customer;
import com.capgemini.training.service.CustomerService;

@Component
public class AppStartUpCommandRunner implements CommandLineRunner {

	@Autowired
	CustomerService customerService;
	
	@Override
	public void run(String... args) throws Exception {
		Customer c1 = new Customer();
		c1.setId(101L);
		c1.setName("A1");
		
		
		Customer c2 = new Customer();
		c2.setId(102L);
		c2.setName("A2");
		
		customerService.save(c1);
		customerService.save(c2);
		List<Customer> customers = customerService.getAllCustomer();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		
		
	}

}
