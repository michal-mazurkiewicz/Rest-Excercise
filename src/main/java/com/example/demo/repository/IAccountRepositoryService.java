package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAccountRepositoryService extends JpaRepository<Account, Long> {

    Account findAccountById(Long id);

    @Query(value = "SELECT * FROM ACCOUNTS", nativeQuery = true)
    List<Account> findAll();
}
