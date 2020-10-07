package com.example.demo;

import com.example.demo.model.Account;
import com.example.demo.model.Currency;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TransferServiceTest {

    @Mock
    private IAccountRepository accountRepository;

    private TransferService transferService;

    private Account accountEuro;
    private Account accountDolar;
    private Account accountEuroTreasury;
    private Account nullAccount;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        transferService = new TransferService(accountRepository);

        accountEuro = new Account((long) 1, "account1", Currency.EURO, 100.0, false);
        accountDolar = new Account((long) 2, "account1", Currency.DOLAR, 100.0, false);
        accountEuroTreasury = new Account((long) 3, "account1", Currency.EURO, 100.0, true);
    }

    @Test
    public void WrongAmountShouldReturnCode0(){
        assertEquals(0, transferService.transfer((long)1, (long)2, -50.00));
    }

    @Test
    public void WrongUserIdShouldReturnCode0(){

        when(accountRepository.findAccountById((long) 1)).thenReturn(accountEuro);
        when(accountRepository.findAccountById((long) 2)).thenReturn(null);

        assertEquals(0, transferService.transfer((long)1, (long)2, 50.00));
    }

    @Test
    public void TreasureUserWithNegativeBalanceShouldReturnCode1(){

        when(accountRepository.findAccountById((long) 1)).thenReturn(accountEuro);
        when(accountRepository.findAccountById((long) 3)).thenReturn(accountEuroTreasury);

        assertEquals(1, transferService.transfer((long)3, (long)1, 150.00));
        assertEquals(-50, accountEuroTreasury.getBalance(), 0);
        assertEquals(250, accountEuro.getBalance(), 0);
    }

    @Test
    public void NoTreasureUserWithNegativeBalanceShouldReturnCode0(){
        when(accountRepository.findAccountById((long) 1)).thenReturn(accountEuro);
        when(accountRepository.findAccountById((long) 3)).thenReturn(accountEuroTreasury);

        assertEquals(0, transferService.transfer((long) 1, (long) 3, 150.00));
    }

    @Test
    public void shouldMakeExchangeOnTransferFromDifferentCurrencies(){
        when(accountRepository.findAccountById((long) 1)).thenReturn(accountEuro);
        when(accountRepository.findAccountById((long) 2)).thenReturn(accountDolar);
        transferService.transfer((long) 1, (long) 2, 10.00);

        assertEquals(90, accountEuro.getBalance(), 0);
        assertEquals(111.7, accountDolar.getBalance(), 0);
    }


}
