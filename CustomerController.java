package org.tapa.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tapa.customer.entity.Customer;
import org.tapa.customer.exception.OrderNotFoundException;
import org.tapa.customer.service.CustomerService;

@RequestMapping("/orders")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> customers = customerService.getAll();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

		Customer customer2 = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer2, HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getById(@PathVariable int id) {

		Customer cust = customerService.getById(id);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable int id) {
		String message = customerService.deleteCustomer(id);
		return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updateCustomer(customer, id);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}

}
