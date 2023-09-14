package com.dnb.JDBCDemo.utils;

import org.springframework.stereotype.Component;

import com.dnb.JDBCDemo.dto.Account;
import com.dnb.JDBCDemo.payload.request.AccountRequest;

@Component
public class RequestToEntityMapper {
	
	public Account getAccountEntityObject(AccountRequest accountRequest) {
		Account account = new Account();
		account.setAccountHolderName(accountRequest.getAccountHolderName());
		account.setAccountType(accountRequest.getAccountType());
		account.setAddress(accountRequest.getAddress());
		account.setBalance(accountRequest.getBalance());
		account.setContactNumber(accountRequest.getContactNumber());
		account.setDob(accountRequest.getDob());
		account.setCustomerId(accountRequest.getCustomerId());
		return account;
	}

}
