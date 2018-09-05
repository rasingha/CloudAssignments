package com.capgemini.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.training.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
