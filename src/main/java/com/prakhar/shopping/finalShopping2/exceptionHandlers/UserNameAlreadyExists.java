package com.prakhar.shopping.finalShopping2.exceptionHandlers;

public class UserNameAlreadyExists extends RuntimeException{
    public UserNameAlreadyExists(String message){
        super(message);
    }



}
