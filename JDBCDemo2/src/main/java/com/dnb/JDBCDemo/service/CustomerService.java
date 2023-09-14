package com.dnb.JDBCDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dnb.JDBCDemo.dto.Customer;
import com.dnb.JDBCDemo.exceptions.IdNotFoundException;

public interface CustomerService  {
	
	public Customer createCustomer(Customer customer);
	
	public Optional<Customer> getCustomerById(int customerId);
	
	public  boolean deleteCustomerById(int customerId) throws IdNotFoundException;
	
	public List<Customer> getAllCustomerDetails();

}
