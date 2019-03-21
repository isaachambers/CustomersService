package com.customerservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customerservice.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	

}
