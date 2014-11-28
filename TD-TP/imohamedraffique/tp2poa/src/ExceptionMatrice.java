
public class ExceptionMatrice extends Exception{
	
	String Exception;
	
	public ExceptionMatrice(String exception)
	{
		Exception = exception;
	}

	@Override
	public String toString() {
		return Exception;
	}

}
