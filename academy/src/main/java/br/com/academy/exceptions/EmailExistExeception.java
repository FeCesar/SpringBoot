package br.com.academy.exceptions;

public class EmailExistExeception extends Exception{
    
    public EmailExistExeception(String message){
        super(message);
    }

    private static final long serialVersionUID = 1L;

}
