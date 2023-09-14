package com.dnb.JDBCDemo.dto;

import java.time.LocalDate;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

import com.dnb.JDBCDemo.exceptions.InvalidAdressException;
import com.dnb.JDBCDemo.exceptions.InvalidBalanceException;
import com.dnb.JDBCDemo.exceptions.InvalidDateException;
import com.dnb.JDBCDemo.utils.CustomAccountIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude="customer")
@Entity      			//used for the ORM
@Table()
@Data
public class Account {
	

	@Id
	//@NotBlank(message = "account id should not be blank") //rather than setters we can prefer this annotation
	@GeneratedValue(strategy = GenerationType.UUID)//we use UUID for string based ids and uses auto,identity,sequence for int and long...
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	//@GenericGenerator(name = "account_seq", strategy = "com.dnb.JDBCDemo.utils.DatePrefixGenerator",
	//parameters = {@Parameter(name=CustomAccountIdGenerator.INCREMENT_PARAM, value = "50"),
			//@Parameter(name=CustomAccountIdGenerator.VALUE_PREFIX_PARAMETER, value = "A_"),
			//@Parameter(name=CustomAccountIdGenerator., value = "f"),
			//@Parameter(name=CustomAccountIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
		//	})
	
	private String accountId;
	@Column(nullable = false)
	@NotBlank(message = "account holder name should not be blank")
	private String accountHolderName;
	//@Transient
	private String accountType;
	@Min(value = 0,message = "value should not be negative")
	private float balance;
	@Length(min = 10,max = 10)
	@jakarta.validation.constraints.Pattern(regexp = "^[0-9]{10}$")
	private String contactNumber;
	@NotBlank(message = "Address should not be blank.")
	private String address;
	private LocalDate accountCreateDate = LocalDate.now();
	@NotNull(message = "provide the dob")
	@jakarta.validation.constraints.Pattern(regexp="\\d{2}/\\d{2}/\\d{4}")
	private String dob;
	private boolean accountStatus;
	//@Transient
	private int customerId;
	
	
	//private Customer customer;
	
	/*
	
	public Account(String accountId, String accountHolderName, String accountType, float balance, String contactNumber,
			String address, LocalDate accountCreateDate, LocalDate dob, boolean accountStatus, int customer) throws InvalidNameException, InvalidBalanceException, InvalidAdressException {
		super();
		//this.accountId = accountId;
		//this.accountHolderName = accountHolderName;
		//this.setAccountHolderName(accountHolderName);//written to handle the exception at the caller itself.
		this.accountType = accountType;
		//this.setBalance(balance);
		this.balance = balance;
		this.contactNumber = contactNumber;
		this.address = address;
		//this.setAddress(address);
		this.accountCreateDate = accountCreateDate;
		this.dob = dob;
		this.accountStatus = accountStatus;
		
		this.customerId = customer;
	}


	


	public void setAccountId(String accountId) {
		this.accountId = accountId;
		
	}


	public void setAccountHolderName(String accountHolderName) throws InvalidNameException {
		//length should be min 2 chars.
		String regEx = "^[a-zA-Z]{2,}$";
		if(Pattern.compile(regEx).matcher(accountHolderName).find())
		this.accountHolderName = accountHolderName;
		else
			throw new InvalidNameException("Please enter a valid name");
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public void setBalance(float balance) throws InvalidBalanceException {
		String regEx = "^[+-]?\\d*\\.?\\d+$";
		if(Pattern.compile(regEx).matcher("75000").find())
		this.balance = balance;
		else 
			throw new InvalidBalanceException("please enter the balance properly");
		
	}


	public void setContactNumber(String contactNumber) {
		String regEx ="^[0-9]{10}$";
		this.contactNumber = contactNumber;
	}


	public void setAddress(String address) throws InvalidAdressException {
		String regEx = "^[a-zA-Z]{2,}$";
		if(Pattern.compile(regEx).matcher(address).find()) 
		this.address = address;
		else
			throw new InvalidAdressException("No address found");
	}


	public void setAccountCreateDate(LocalDate accountCreateDate) throws InvalidDateException {
		String regEx = "\\d{2}/\\d{2}/\\d{4}";
		
		if(Pattern.compile(regEx).matcher("2023,09,09").find()) 
		this.accountCreateDate = accountCreateDate;
		else 
			throw new InvalidDateException("Enter the Valid date");
	}


	public void setDob(LocalDate dob) {
		String regEx = "\\d{2}/\\d{2}/\\d{4}";
		this.dob = dob;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}

	public void setCustomer(int customer) {
		this.customerId = customer;
	}
	
	
	*/

}
