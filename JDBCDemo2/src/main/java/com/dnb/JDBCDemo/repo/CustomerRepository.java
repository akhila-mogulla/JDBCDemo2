package com.dnb.JDBCDemo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dnb.JDBCDemo.dto.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	
/*public Customer createCustomer( Customer customer);
	
	public  Optional<Customer> getCustomerById(int customerId);
	
	public  Optional<Customer> deleteCustomerById(int customerId);
	
	public  List<Customer> getAllCustomers(int customerId);*/


}
