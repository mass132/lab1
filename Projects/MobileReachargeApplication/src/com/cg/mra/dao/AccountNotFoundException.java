package com.cg.mra.dao;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(final String msg){
        super(msg);
    }

    public AccountNotFoundException(final String msg,final Throwable exc){
        super(msg,exc);
    }

}
