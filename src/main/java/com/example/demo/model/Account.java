package com.example.demo.model;

import javax.persistence.Entity;
import java.util.Currency;


public class Account {

    private Long id;
    private String name;
    private Currency currency;
    private double balance;

    public Account() {
    }

    public Account(Long id, String name, Currency currency, double balance) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
