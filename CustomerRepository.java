package org.tapa.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.tapa.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
