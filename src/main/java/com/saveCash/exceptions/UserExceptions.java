package com.saveCash.exceptions;

public class UserExceptions {

    public static class DuplicateUserException extends RuntimeException{
        public DuplicateUserException(String message){
            super(message);
        }
    }
}
