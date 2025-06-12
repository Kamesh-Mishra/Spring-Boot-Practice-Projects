package com.banking.demo.mapper;

import com.banking.demo.dto.AccountDto;
import com.banking.demo.entity.Account;

public class AccountMapperr {

	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
							accountDto.id(),
							accountDto.accountHolderName(),
							accountDto.balance()
							);
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
								account.getId(),
								account.getAccountHolderName(),
								account.getBalance()
								);
		return accountDto;
	}
	
	
}
