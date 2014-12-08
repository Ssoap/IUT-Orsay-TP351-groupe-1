package edu.iut.exceptions;

public class ProgramArgumentException extends Exception {
    public ProgramArgumentException()
    { super(); }
    
    public ProgramArgumentException(String message)
    { super(message); }
    
    public ProgramArgumentException(ProgramArgumentException exception)
    { super(exception); }
    
}
