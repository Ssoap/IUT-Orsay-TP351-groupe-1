package exceptions;

public class ExceptionMatrice extends Exception {
	
	private String msg ;
	
	public ExceptionMatrice(String msg){
		this.msg = msg ;
	}

	
	@Override
	public String toString() {
		return "ExceptionMatrice [ msg = " + msg + " ]";
	}
	
}