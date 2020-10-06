package com.example.demo.model;

public enum Currency {
    EURO("EURO"),
    DOLAR("DOLAR");

    private String value;

    Currency(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
