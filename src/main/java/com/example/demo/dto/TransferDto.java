package com.example.demo.dto;

public class TransferDto {
    private Long idFrom;
    private Long idTo;
    private double amount;

    public TransferDto() {
    }

    public TransferDto(Long idFrom, Long idTo, double amount) {
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.amount = amount;
    }

    public Long getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(Long idFrom) {
        this.idFrom = idFrom;
    }

    public Long getIdTo() {
        return idTo;
    }

    public void setIdTo(Long idTo) {
        this.idTo = idTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
