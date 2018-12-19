package com.example.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
  
}
