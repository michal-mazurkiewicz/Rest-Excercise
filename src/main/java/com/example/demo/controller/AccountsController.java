package com.example.demo.controller;

import com.example.demo.dto.TransferDto;
import com.example.demo.model.Account;
import com.example.demo.service.IAccountService;
import com.example.demo.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/accounts")
public class AccountsController {

    private final IAccountService accountService;
    private final ITransferService transferService;


    @Autowired
    public AccountsController(IAccountService accountService, ITransferService transferService) {
        this.accountService = accountService;
        this.transferService = transferService;
    }

    @PostMapping
    public void createAccount(@RequestBody Account account){
        accountService.createAccount(account);
    }

    @GetMapping(value = "getbyid/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @GetMapping
    public List<Account> getAllAccounts(){
       return accountService.getAllAccounts();
    }


    @PostMapping(value = "/transfer")
    public String transfer(@RequestBody TransferDto transfer){
       return transferService.transfer(transfer.getIdFrom(), transfer.getIdTo(), transfer.getAmount());
    }

}
