package Exceptions;

public class ExceptionMatrice extends Exception{

	String message;
	
	public ExceptionMatrice(String message){
		this.message=message;
	}

	public String toString()
	{
		return "Exception : " + message;
	}
}
