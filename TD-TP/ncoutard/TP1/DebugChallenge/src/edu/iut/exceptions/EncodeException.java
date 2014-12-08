package edu.iut.exceptions;

public class EncodeException extends Exception {
    public EncodeException()
    { super(); }
    
    public EncodeException(String message)
    { super(message); }
    
    public EncodeException(EncodeException exception)
    { super(exception); }
    
}
