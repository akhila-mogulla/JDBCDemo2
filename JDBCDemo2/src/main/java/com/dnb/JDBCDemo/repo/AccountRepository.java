package com.dnb.JDBCDemo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.dnb.JDBCDemo.dto.Account;
@Repository
public interface AccountRepository extends CrudRepository<Account, String>{
	
	public Optional<Account> findByContactNumber(String contactNumber);
	
	public List<Account> findAllByContactNumber(String contactNumber);
	
	//List<Account> fi
	


}


















/*public Account createAccount(Account account);

public  Optional<Account> getAccountById(String accountId);

public  Optional<Account> deleteAccountById(String accountId);

public  List<Account> getAllAccounts(String accountId);*/