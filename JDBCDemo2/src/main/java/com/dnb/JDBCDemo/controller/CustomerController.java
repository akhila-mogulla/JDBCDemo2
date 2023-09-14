package com.dnb.JDBCDemo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dnb.JDBCDemo.dto.Customer;
import com.dnb.JDBCDemo.exceptions.IdNotFoundException;
import com.dnb.JDBCDemo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteAccountById(@PathVariable("customerId") int customerId) throws IdNotFoundException {
		boolean customer = customerService.deleteCustomerById(customerId);
		if(customer) {
			return ResponseEntity.noContent().build();
			
		}
		else
		throw new IdNotFoundException("customer id not available to delete");
	}
	

	
	@GetMapping("/{customerId}") //it should help us to get the specific account details 
	

	public ResponseEntity<?> getAccountById(@PathVariable("customerId") int customerId) throws IdNotFoundException{
		Optional<Customer> optional = customerService.getCustomerById(customerId);
		if(optional.isPresent()) {
		return ResponseEntity.ok(optional.get());
		}
		else {
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("message", "Account id not found");
//			map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
//			ResponseEntity<?> responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
//			return responseEntity;
			//return responseEntity.notFound().build();
			
			throw new IdNotFoundException("Enter the available customer id");
		}
	}
	
	
@GetMapping("/all") //it should help us to get the specific account details 
	

	public ResponseEntity<?> getAllAccounts(/*@PathVariable("accountId") String accountId*/) throws IdNotFoundException{
		List<Customer> optional = customerService.getAllCustomerDetails();

		return ResponseEntity.ok(optional);
		

	}
	
//	@GetMapping("/allAccounts/{contactNumber}")
//	public ResponseEntity<?> getAllAccountBycontactNumber(@PathVariable("contactNumber") String contactNumber ) throws InvalidContactNumberException{
//		List<Account> list1 = new ArrayList<Account>();
//		list1 = customerService.getAllAccountByContactNumber(contactNumber);
//		return ResponseEntity.ok(list1);
//	}
//	
//	@GetMapping("/num/{contactNumber:^[0-9]{10}$}")
//	public ResponseEntity<?> getAccountBycontactNumber(@PathVariable("contactNumber") String contactNumber ) throws InvalidContactNumberException{
//		Optional<Account> optional = customerService.getAccountByContactNumber(contactNumber);
//		if(optional.isPresent()) {
//			return ResponseEntity.ok(optional.get());
//			}
//			else {
////				Map<String, String> map = new HashMap<String, String>();
////				map.put("message", "Account id not found");
////				map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
////				ResponseEntity<?> responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
////				return responseEntity;
//				//return responseEntity.notFound().build();
//				
//				throw new InvalidContactNumberException("Enter the available contact number");
//			}
//	}
	
	
	@PostMapping("/create")//@RequestMapping+post method==>spring 4.3.x
	public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer) {
		Customer customer2;

	
			customer2 = customerService.createCustomer(customer);
			return new ResponseEntity(customer2,HttpStatus.CREATED);

			//return ResponseEntity.badRequest().body(e.getMessage());
		
	
		//status code 200 but the expected is 201(created)
		
	}

}
