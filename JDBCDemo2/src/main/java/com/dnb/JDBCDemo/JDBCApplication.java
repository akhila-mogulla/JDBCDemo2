package com.dnb.JDBCDemo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import javax.naming.InvalidNameException;
import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.JDBCDemo.dto.Account;
import com.dnb.JDBCDemo.dto.Customer;
import com.dnb.JDBCDemo.exceptions.IdNotFoundException;
import com.dnb.JDBCDemo.exceptions.InvalidAdressException;
import com.dnb.JDBCDemo.exceptions.InvalidBalanceException;
import com.dnb.JDBCDemo.exceptions.InvalidDateException;
import com.dnb.JDBCDemo.service.AccountService;
import com.dnb.JDBCDemo.service.CustomerService;

@SpringBootApplication

public class JDBCApplication {

	public static void main(String[] args) {
	//	ApplicationContext applicationContext = 
				SpringApplication.run(JDBCApplication.class, args);
		
//		Account account = new Account();
//		
//
//			try {
//				applicationContext.getBean(AccountService.class).createAccount(account);
//			} catch (BeansException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IdNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
					//account.setContactNumber("ab");
					

			

	}
}
		

		//applicationContext.getBean(AccountService.class).getAllAccounts().forEach(e -> System.out.println(e));
		//applicationContext.getBean(CustomerService.class).getAllCustomerDetails().forEach(e -> System.out.println(e));

/*	AccountService accountService = applicationContext.getBean(AccountService.class);
		CustomerService customerService = applicationContext.getBean(CustomerService.class);
		Account account2 = null;
		Customer customer2 = null;

		try {
			account2 = new Account("mickey", "Savings", 85000, "9876873450", "america", LocalDate.now(),
					LocalDate.of(2000, 8, 8), true, 1);
			//
			customer2 = new Customer(2, "Tommy", "9876501234", "Hyderabad", "hdtfr12341", "87634521354689");
		} catch (InvalidNameException | InvalidBalanceException | InvalidAdressException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			// e.printStackTrace();

		}

		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println(dataSource != null);
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("select an option from the below...\n1.Account \n2.Customer");
		int operations = sc.nextInt();
		switch (operations) {
		case 1:
			while (true) {
				System.out.println(
						"operations\n 1.create account \n 2.get account\n 3.delete the account.\n 4.Exit from code\n Enter any option: ");
				int condition = sc.nextInt();
				switch (condition) {
				case 1:// AccountServiceImpl.getInstance()
					try {
						accountService.createAccount(account2);
					} catch (IdNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					System.out.println("created account");
					break;
				case 2:// AccountServiceImpl.getInstance()
					accountService.getAccountById("abc12");
					System.out.println("you got the connection");
					break;
				case 3:// AccountServiceImpl.getInstance()
					try {
						accountService.deleteAccountById("abc12");
					} catch (IdNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("deleted successfully");
					break;
				case 4:
					System.out.println("thanks! you got exit...");
					System.exit(0);

					break;

				default:
					System.out.println("enter the proper value");
					break;
				}
				break;
			}

		case 2:
			while (true) {
				System.out.println(
						"operations\n 1.create customer \n 2.get customer\n 3.delete the customer.\n 4.Exit from code\n Enter any option: ");

				int condition = sc.nextInt();
				switch (condition) {
				case 1:// AccountServiceImpl.getInstance()

					customerService.createCustomer(customer2);
					System.out.println("created customer details");
					break;
				case 2:// AccountServiceImpl.getInstance()
					customerService.getCustomerById(2);
					System.out.println("you got the connection");
					break;
				case 3:// AccountServiceImpl.getInstance()
					try {
						customerService.deleteCustomerById(2);
					} catch (IdNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("deleted successfully");
					break;
				case 4:
					System.out.println("thanks! you got exit...");
					System.exit(0);

					break;

				default:
					System.out.println("enter the proper value");
					break;
				}

				break;
			}

		default:
			System.out.println("Enter the proper operation...");
			break;

		}
		}
*/

	


// TODO Auto-generated method stub

/*
 * String a ="Akhi"; String b = null; Optional<String> opt =
 * Optional.ofNullable(b); System.out.println(opt.isEmpty());
 * 
 * //localDate to java.sql.date
 * 
 * java.sql.Date date = Date.valueOf(LocalDate.now()); System.out.println(date);
 */

// Account account = new Account();
/*
 * account.setAccountHolderName("Akhila"); account.setAccountId("13");
 * account.setAccountType("Savings"); account.setBalance(100000);
 * account.setAccountStatus(true); account.setAddress("hyderabad");
 * account.setContactNumber("98763554423"); LocalDate ld = LocalDate.of( 2026 ,
 * 1 , 23 ); account.setDob(ld );
 */

// AccountServiceImpl.getInstance().createAccount(account);
// asi = new AccountServiceImpl();
// System.out.println(asi.createAccount(account));

/*
 * Scanner sc = new Scanner(System.in);
 * 
 * ApplicationContext applicationContext = new
 * AnnotationConfigApplicationContext(Config.class,DBConfig.class);
 * DataSourceBean dataSourceBean =
 * applicationContext.getBean("dataSourceBean",DataSourceBean.class);
 * System.out.println("the data source bean "+ dataSourceBean!=null);
 * 
 * DBUtils dbUtils = applicationContext.getBean(DBUtils.class); AccountService
 * accountService = applicationContext.getBean(AccountService.class);
 * 
 * 
 * 
 */

/*
 * account2.setAccountHolderName("anil"); account2.setAccountId("sdgre");
 * account2.setAccountType("Savings"); account2.setBalance(100000);
 * account2.setAccountStatus(true); account2.setAddress("pune");
 * account2.setContactNumber("9876354423"); //LocalDate ld = LocalDate.of( 2026
 * , 1 , 23 ); account2.setDob(LocalDate.of( 2000 , 1 , 23 ) );
 * account2.setCustomer(new Customer(1, "anand", "9876543210", "banglore",
 * "hdfry65312", "6573425167")); System.out.println(account2);
 */
