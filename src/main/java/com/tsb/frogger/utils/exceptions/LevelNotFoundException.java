package com.tsb.frogger.utils.exceptions;

public class LevelNotFoundException extends Exception{
    public LevelNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
