package org.tapa.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tapa.customer.entity.Customer;

public interface CustomerService {

	public List<Customer> getAll(); // getting all the customer details.

	public Customer getById(int id); // retrieve a customer given by Id.

	public Customer addCustomer(Customer customer);// Adding a new Customer.

	public String deleteCustomer(int id); // delete the record according to id.
	
	public Customer updateCustomer(Customer customer, int id);

}
