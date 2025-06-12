package com.banking.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
