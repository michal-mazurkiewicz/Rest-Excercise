package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/accounts")
public class AccountsController {

    private final IAccountService accountService;

    @Autowired
    public AccountsController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public void createAccount(@RequestBody Account account){
        accountService.createAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts(){
       return accountService.getAllAccounts();
    }

    @GetMapping(path = "{id}")
    public Account getAccountById(@PathVariable("id") Long id){
        return accountService.getAccountById(id);
    }

}
