package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "currency")
    private Currency currency;
    @Column(name = "balance")
    private double balance;
    @Column(name = "treasury")
    private boolean treasury;

    public Account() {
    }

    public Account(Long id, String name, Currency currency, double balance, boolean treasury) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.balance = balance;
        this.treasury = treasury;

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

    public boolean isTreasury() {
        return treasury;
    }

    public void setTreasury(boolean treasury){
        this.treasury = treasury;
    }
}
