package com.dnb.JDBCDemo.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString//(exclude="customer")
@Entity      			//used for the ORM
@Table()
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Customer {
	
	@Id
	//@NotBlank
	private int customerId;
	private String customerName;
	private String customerContactNumber;
	private String customerAddress;
	private String customerPAN;
	//private String customerUUID;

}
