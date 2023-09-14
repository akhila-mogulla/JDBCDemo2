package com.dnb.JDBCDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.JDBCDemo.dto.Customer;
import com.dnb.JDBCDemo.exceptions.IdNotFoundException;
import com.dnb.JDBCDemo.repo.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	
private static CustomerService customerService = null;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
		//return null;
	}

	@Override
	public Optional<Customer> getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		//return Optional.empty();
		return customerRepository.findById(customerId);
	}

	@Override
	public boolean deleteCustomerById(int customerId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		//return false;
		if(customerRepository.existsById(customerId)) {
			customerRepository.deleteById(customerId);
			return true;
		}
		else
			throw new IdNotFoundException("No customer id find to delete");
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepository.findAll();
	}
}

/*
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.createCustomer(customer);
		//return null;
	}

	@Override
	public Optional<Customer> getCustomerById(int customerid) {
		// TODO Auto-generated method stub
		
		return customerRepository.getCustomerById(customerid);
		//return Optional.empty();
	}

	@Override
	public Optional<Customer> deleteCustomerById(int customerid) {
		// TODO Auto-generated method stub
		return customerRepository.deleteCustomerById(customerid);
		//return Optional.empty();
	}

}*/
