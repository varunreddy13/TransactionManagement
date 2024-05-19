package com.varun.tx.exception;

public class InsufficentAmountException extends RuntimeException{

    public InsufficentAmountException(String msg){
        super(msg);
    }
}
