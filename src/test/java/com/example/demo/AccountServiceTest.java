package com.example.demo;

import com.example.demo.model.Account;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    @Mock
    private IAccountRepository accountRepository;

    private AccountService accountService;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        accountService = new AccountService(accountRepository);
    }

    @Test
    public void shouldfindAllReturnArray(){
        List<Account> accounts = new ArrayList<>();
        when(accountRepository.findAll()).thenReturn(accounts);
        assertEquals(accounts, accountService.getAllAccounts());
    }

    @Test
    public void shouldfindAllReturnNull(){
        when(accountRepository.findAll()).thenReturn(null);
        assertEquals(null, accountService.getAllAccounts());
    }

    @Test
    public void shouldReturnOneById(){
        Account account = new Account();
        when(accountRepository.findAccountById(anyLong())).thenReturn(account);
        assertEquals(account, accountService.getAccountById(anyLong()));
    }

    @Test
    public void shouldFindOneByIdReturnNull(){
        when(accountRepository.findAccountById(anyLong())).thenReturn(null);
        assertEquals(null, accountService.getAccountById(anyLong()));
    }
}
