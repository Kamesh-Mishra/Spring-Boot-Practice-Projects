package com.banking.demo.dto;

//import lombok.AllArgsConstructor;
//import lombok.Data;

//@AllArgsConstructor
//@Data
//public class AccountDto {
//	private Long id;
//	private String accountHolderName;
//	private double balance;
//}


public record AccountDto(Long id,
						String accountHolderName,
						double balance) {
	
}