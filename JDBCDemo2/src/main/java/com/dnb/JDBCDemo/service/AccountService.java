package com.dnb.JDBCDemo.service;

import java.util.List;
import java.util.Optional;

import com.dnb.JDBCDemo.dto.Account;
import com.dnb.JDBCDemo.exceptions.IdNotFoundException;
import com.dnb.JDBCDemo.exceptions.InvalidAdressException;
import com.dnb.JDBCDemo.exceptions.InvalidContactNumberException;
import com.dnb.JDBCDemo.exceptions.InvalidDateException;
import com.dnb.JDBCDemo.exceptions.InvalidNameException;

public interface AccountService{
	
	public Account createAccount(Account account) throws IdNotFoundException,InvalidAdressException,InvalidDateException;
	
	public Optional<Account> getAccountById(String accountId) throws IdNotFoundException;
	
	public Optional<Account> getAccountByContactNumber(String contactNumber)  throws InvalidContactNumberException;
	
	public List<Account> getAllAccountByContactNumber(String contactNumber)  throws InvalidContactNumberException;
	
	public  boolean deleteAccountById(String accountId) throws IdNotFoundException;
	
	public List<Account> getAllAccounts();

}
