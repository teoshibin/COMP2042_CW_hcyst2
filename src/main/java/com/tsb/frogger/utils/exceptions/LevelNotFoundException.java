package com.tsb.frogger.utils.exceptions;

/**
 * level not found exception
 * thrown when specified level is not present
 */
public class LevelNotFoundException extends Exception{
    /**
     * constructor
     *
     * @param errorMessage error message
     */
    public LevelNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
