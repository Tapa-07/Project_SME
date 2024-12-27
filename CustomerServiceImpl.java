package org.tapa.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.tapa.customer.entity.Customer;
import org.tapa.customer.exception.OrderNotFoundException;
import org.tapa.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAll() {

		return customerRepository.findAll();
	}

	@Override
	public Customer getById(int id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new OrderNotFoundException("order with id = " + id + " is not found"));
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public String deleteCustomer(int id) {
		Optional<Customer> del = customerRepository.findById(id);

		if (del.isEmpty()) {
			throw new OrderNotFoundException("Order with id " + id + " not found!!! ");
		}

		customerRepository.deleteById(id);
		return "Order Details with id " + id + " Deleted Successfully";

	}

	/**
	 * Service 
	 */
	@Override
	public Customer updateCustomer(Customer customer, int id) {

		Optional<Customer> update = customerRepository.findById(id);

		if (update.isEmpty()) {
			throw new OrderNotFoundException("Order with id " + id + " does not exist.");
		}
		Customer updatedCustomer = update.get();
		updatedCustomer.setCustomerName(customer.getCustomerName());
		updatedCustomer.setOrderDate(customer.getOrderDate());
		updatedCustomer.setTotalAmount(customer.getTotalAmount());
		updatedCustomer.setItems(customer.getItems());
		return customerRepository.save(updatedCustomer);
	}

}