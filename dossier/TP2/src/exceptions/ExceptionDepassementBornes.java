package exceptions;

public class ExceptionDepassementBornes extends Exception {
	
	private String msg ;
	
	public ExceptionDepassementBornes(String msg){
		this.msg = msg ;
	}

	
	@Override
	public String toString() {
		return "ExceptionMatrice [ msg = " + msg + " ]";
	}
	
}
