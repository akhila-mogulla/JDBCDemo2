package com.dnb.JDBCDemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.coyote.Response;
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

import com.dnb.JDBCDemo.dto.Account;
import com.dnb.JDBCDemo.exceptions.IdNotFoundException;
import com.dnb.JDBCDemo.exceptions.InvalidAdressException;
import com.dnb.JDBCDemo.exceptions.InvalidContactNumberException;
import com.dnb.JDBCDemo.exceptions.InvalidDateException;
import com.dnb.JDBCDemo.exceptions.InvalidNameException;
import com.dnb.JDBCDemo.payload.request.AccountRequest;
import com.dnb.JDBCDemo.service.AccountService;
import com.dnb.JDBCDemo.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	
	@Autowired
	RequestToEntityMapper mapper;
	
	@Autowired
	AccountService accountService;
	
	@DeleteMapping("/{accountId}")
	public ResponseEntity<?> deleteAccountById(@PathVariable("accountId") String accoutId) throws IdNotFoundException {
		boolean account = accountService.deleteAccountById(accoutId);
		if(account) {
			return ResponseEntity.noContent().build();
			
		}
		else
		throw new IdNotFoundException("account id not available to delete");
	}
	

	
	@GetMapping("/{accountId}") //it should help us to get the specific account details 
	

	public ResponseEntity<?> getAccountById(@PathVariable("accountId") String accountId) throws IdNotFoundException{
		Optional<Account> optional = accountService.getAccountById(accountId);
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
			
			throw new IdNotFoundException("Enter the available account id");
		}
	}
	
	
@GetMapping("/all") //it should help us to get the specific account details 
	

	public ResponseEntity<?> getAllAccounts(/*@PathVariable("accountId") String accountId*/) throws IdNotFoundException{
		List<Account> optional = accountService.getAllAccounts();

		return ResponseEntity.ok(optional);
		

	}
	
	@GetMapping("/allAccounts/{contactNumber}")
	public ResponseEntity<?> getAllAccountBycontactNumber(@PathVariable("contactNumber") String contactNumber ) throws InvalidContactNumberException{
		List<Account> list1 = new ArrayList<Account>();
		list1 = accountService.getAllAccountByContactNumber(contactNumber);
		return ResponseEntity.ok(list1);
	}
	
	@GetMapping("/num/{contactNumber:^[0-9]{10}$}")
	public ResponseEntity<?> getAccountBycontactNumber(@PathVariable("contactNumber") String contactNumber ) throws InvalidContactNumberException{
		Optional<Account> optional = accountService.getAccountByContactNumber(contactNumber);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
			}
			else {
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("message", "Account id not found");
//				map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
//				ResponseEntity<?> responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
//				return responseEntity;
				//return responseEntity.notFound().build();
				
				throw new InvalidContactNumberException("Enter the available contact number");
			}
	}
	
	
	
	
	
	@PostMapping("/create")//@RequestMapping+post method==>spring 4.3.x
	public ResponseEntity<?> createAccount(@Valid @RequestBody AccountRequest account) {
		Account account2 = mapper.getAccountEntityObject(account);
		

		try {
			Account account3 = accountService.createAccount(account2);
			return new ResponseEntity(account3,HttpStatus.CREATED);
			//return ResponseEntity.ok(mapper.getAccountEntityObject(account));
		} catch (IdNotFoundException | InvalidAdressException | InvalidDateException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	
		//status code 200 but the expected is 201(created)
		
}

}
