package com.customerservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerservice.domain.Customer;
import com.customerservice.repositories.CustomerRepository;
import com.customerservice.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer deleteCustomer(Long id) {
		Customer c = repository.findById(id).orElse(null);
		if (null != c) {
			repository.delete(c);
			return c;
		} else {
			return null;
		}

	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) throws Error {
		Customer c = repository.findById(id).orElse(null);
		if (null != c) {
			c.setEmail(customer.getEmail());
			c.setFirstName(customer.getFirstName());
			c.setSecondName(customer.getSecondName());
			return repository.save(c);
		} else {
			return null;
		}

	}

	@Override
	public Customer getCustomerById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> getAllCustomers = new ArrayList<Customer>();
		for (Customer cust : repository.findAll()) {
			getAllCustomers.add(cust);
		}
		return getAllCustomers;
	}

}
