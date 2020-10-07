package com.example.demo.service;

import org.springframework.http.ResponseEntity;

public interface ITransferService {

    int transfer(Long idFrom, Long idTo, double amount);
}
