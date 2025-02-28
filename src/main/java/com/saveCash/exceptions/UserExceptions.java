package com.saveCash.exceptions;

public class UserExceptions extends RuntimeException {

    public static class DuplicateUserException extends RuntimeException{
        public DuplicateUserException(String message){
            super(message);
        }
    }

    public static class UserNotFoundException extends RuntimeException{
        public UserNotFoundException(String message){
            super(message);
        }
    }

    public static class InvalidPasswordException extends RuntimeException{
        public InvalidPasswordException(String message){
            super(message);
        }
    }
}
