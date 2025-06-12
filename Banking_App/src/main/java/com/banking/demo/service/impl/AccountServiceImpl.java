package com.banking.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banking.demo.dto.AccountDto;
import com.banking.demo.entity.Account;
import com.banking.demo.exception.AccountException;
import com.banking.demo.mapper.AccountMapperr;
import com.banking.demo.repository.AccountRepository;
import com.banking.demo.service.AccountService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapperr.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapperr.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new AccountException("Account does not exist!"));
		return AccountMapperr.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new AccountException("Account does not exist!"));
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);		
		return AccountMapperr.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new AccountException("Account does not exist!"));
		if(account.getBalance() < amount)
			throw new RuntimeException("Insufficient amount");
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapperr.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapperr.mapToAccountDto(account))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new AccountException("Account does not exist!"));
		accountRepository.deleteById(id);
	}
	
	

	
}
