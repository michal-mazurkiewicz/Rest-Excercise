package com.example.demo.service;

import com.example.demo.model.Account;

import java.util.List;

public interface IAccountService {

    void createAccount(Account account);

    Account getAccountById(Long id);

    List<Account> getAllAccounts();
}
