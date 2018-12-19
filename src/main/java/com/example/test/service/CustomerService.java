package com.example.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.test.repository.CustomerRepository;
import com.example.test.model.Customer;

@Service("customerService")
public class CustomerService {
	
    private CustomerRepository customerRepository;    
    
//    public List<Customer> listAll() {
//        List<Customer> custs = new ArrayList<>();
//        customerRepository.findAll().forEach(custs::add);
//        return custs;
//    }

}