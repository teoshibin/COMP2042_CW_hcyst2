package com.tsb.frogger.exceptions;

public class LevelNotFoundException extends Exception{
    public LevelNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
