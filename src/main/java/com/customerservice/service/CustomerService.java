package com.customerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customerservice.domain.Customer;

@Service
public interface CustomerService {

	public Customer saveCustomer(Customer customer);

	public Customer deleteCustomer(Long id);

	public Customer updateCustomer(Long id, Customer customer);

	public Customer getCustomerById(Long id);

	public List<Customer> getAllCustomers();

}
