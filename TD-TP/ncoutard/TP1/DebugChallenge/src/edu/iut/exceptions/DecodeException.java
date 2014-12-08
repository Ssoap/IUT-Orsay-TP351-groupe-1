package edu.iut.exceptions;

public class DecodeException extends Exception {
    public DecodeException()
    { super(); }
    
    public DecodeException(String message)
    { super(message); }
    
    public DecodeException(DecodeException exception)
    { super(exception); }
    
}
