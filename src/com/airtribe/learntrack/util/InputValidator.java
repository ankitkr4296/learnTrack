package com.airtribe.learntrack.util;
import com.airtribe.learntrack.exception.InvalidInputException;

public final class InputValidator {
    private InputValidator(){

    }

    public static String requireText(String value,String field){
        if(value==null||value.trim().isEmpty())
            throw new InvalidInputException(field+" cannot be empty.");
        return value.trim();
    }
    public static int requirePositive(int value,String field){
        if(value<=0)
            throw new InvalidInputException(field+" must be greater than zero.");
        return value;
    }
    public static String optionalEmail(String email){
        if(email==null||email.trim().isEmpty())return null;
        String v=email.trim();
        if(!v.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new InvalidInputException("Please enter a valid email address.");
        return v;
    }
}
