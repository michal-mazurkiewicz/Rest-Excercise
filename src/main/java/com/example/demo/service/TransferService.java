package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService implements ITransferService {

    private final IAccountRepository accountRepository;

    @Autowired
    public TransferService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public String transfer(Long fromID, Long toID, double amount) {
        if(amount < 0){
            return "Error: Amount must be positive number";
        }

        Account fromAccount = accountRepository.findAccountById(fromID);
        Account toAccount = accountRepository.findAccountById(toID);
        if(isTransferPossible(fromAccount, toAccount, amount)){
            double fromBalance = fromAccount.getBalance();
            double toBalance = toAccount.getBalance();

            fromAccount.setBalance(fromBalance - amount);
            toAccount.setBalance(fromBalance + amount);

            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);
            return "OK: Transfer completed!";
        }

        return "Transfer failure";
    }

    private boolean isTransferPossible(Account fromAccount, Account toAccount, double amount){
        if(fromAccount != null && toAccount != null){
            return hasEnoughtMoney(fromAccount, amount) || isTreasury(fromAccount);
        }
        return false;
    }

    private boolean hasEnoughtMoney(Account fromAccount, double amount) {
        return fromAccount.getBalance() - amount >= 0;
    }

    private boolean isTreasury(Account fromAccount) {
        return fromAccount.isTreasury();
    }
}
