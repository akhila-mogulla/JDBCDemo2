package com.dnb.JDBCDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dnb.JDBCDemo.dto.Account;
import com.dnb.JDBCDemo.dto.Customer;
import com.dnb.JDBCDemo.exceptions.IdNotFoundException;
import com.dnb.JDBCDemo.exceptions.InvalidContactNumberException;
import com.dnb.JDBCDemo.repo.AccountRepository;
//import com.dnb.JDBCDemo.repo.AccountRepositoryImpl;
import com.dnb.JDBCDemo.repo.CustomerRepository;
@Service//("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	//@Qualifier("accountRepo2Impl")
	AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
		//return null;
	}

	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		//System.out.println(getAccountById(accountId).isPresent());
		return accountRepository.findById(accountId);
	}

	@Override
	public boolean deleteAccountById(String accountId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(accountRepository.existsById(accountId)) {
			accountRepository.deleteById(accountId);
			return true;
		}
		
		else
			throw new IdNotFoundException("We cannot find any id to delete...");
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return (List<Account>) accountRepository.findAll();
		//return null;
	}

	@Override
	public Optional<Account> getAccountByContactNumber(String contactNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findByContactNumber(contactNumber);
		//return Optional.empty();
	}

	@Override
	public List<Account> getAllAccountByContactNumber(String contactNumber) throws InvalidContactNumberException {
		// TODO Auto-generated method stub
		return accountRepository.findAllByContactNumber(contactNumber);
		//return null;
	}
	
	
}
	/*private static AccountService accountService = null;
	
	@Autowired
	//@Qualifier("accountRepo2Impl")
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	
	private Account AccountServiceImpl (Account account) {
		// TODO Auto-generated constructor stub
		return account;
	}

	public static AccountService getInstance() {
		// TODO Auto-generated method stub
		
		synchronized (AccountRepositoryImpl.class) {
			if(accountService==null) {
				accountService = new AccountServiceImpl();
			}
			
		}
		return accountService;

	}
	//AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
	
	@Override
	public Account createAccount(Account account2) throws IdNotFoundException {
		// TODO Auto-generated method stub
		//AccountRepositoryImpl.getInstance().createAccount(account);
		//accountService = (AccountService) AccountRepositoryImpl.getInstance().createAccount(account);
		//AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
		Optional<Customer> optional = customerRepository.getCustomerById(account2.getCustomer().getCustomerid());
		if(optional.isPresent())
		return accountRepository.createAccount(account2);
		else {
			throw new IdNotFoundException("Customer id not found");
		}
			
		
		//return account;
		
	}
	


	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		//AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
		return accountRepository.getAccountById(accountId);
		//return null;
	}

	@Override
	public Optional<Account> deleteAccountById(String accountId) {
		// TODO Auto-generated method stub
		//return null;
		return accountRepository.deleteAccountById(accountId);
	}
	}*/
	


