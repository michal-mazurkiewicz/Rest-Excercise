package com.example.demo.controller;

import com.example.demo.dto.TransferDto;
import com.example.demo.model.Account;
import com.example.demo.service.IAccountService;
import com.example.demo.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class AccountsController {

    private final IAccountService accountService;
    private final ITransferService transferService;


    @Autowired
    public AccountsController(IAccountService accountService, ITransferService transferService) {
        this.accountService = accountService;
        this.transferService = transferService;
    }

    @PostMapping(value = "/account")
    public ResponseEntity createAccount(@RequestBody Account account){
        accountService.createAccount(account);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/account")
    public ResponseEntity<Account> getAccountById(@RequestParam Long id){
        Account account = accountService.getAccountById(id);
        return account == null ?  ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(account);
    }

    @GetMapping(value = "/accounts")
    public ResponseEntity<List> getAllAccounts(){
       List<Account> accountList = accountService.getAllAccounts();
        return accountList == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(accountList);
    }


    @PostMapping(value = "/transfer")
    public ResponseEntity transfer(@RequestBody TransferDto transfer){
       int code = transferService.transfer(transfer.getIdFrom(), transfer.getIdTo(), transfer.getAmount());
       return code == 1 ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

}
