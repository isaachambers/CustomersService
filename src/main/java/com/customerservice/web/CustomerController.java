package com.customerservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customerservice.domain.Customer;
import com.customerservice.service.CustomerService;

@RestController()
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/getAllCustomers", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllCustomers() {
		try {
			List<Customer> customers = customerService.getAllCustomers();
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) {
		Customer c;
		try {
			c = customerService.saveCustomer(customer);
			return new ResponseEntity<>(c, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@RequestMapping(path = "/{customerId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable() Long customerId) {
		try {
			Customer c = customerService.deleteCustomer(customerId);
			if (c != null) {
				return new ResponseEntity<>(c, HttpStatus.OK);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@RequestMapping(path = "/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable() Long customerId) {
		try {
			Customer c = customerService.getCustomerById(customerId);
			if (c != null) {
				return new ResponseEntity<>(c, HttpStatus.OK);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	

	@RequestMapping(path = "/{customerId}", method = RequestMethod.PATCH)
	public ResponseEntity<Object> UpdateCustomer( @PathVariable() Long customerId,@RequestBody Customer customer) {
		System.out.println("Here");
		Customer c;
		try {
			c = customerService.updateCustomer(customerId,customer);
			if (c != null) {
				return new ResponseEntity<>(c, HttpStatus.OK);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
