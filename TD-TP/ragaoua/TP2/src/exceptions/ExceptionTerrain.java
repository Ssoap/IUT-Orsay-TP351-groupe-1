package exceptions;

public class ExceptionTerrain extends Exception {

	private String msg ;
	
	public ExceptionTerrain(String msg){
		this.msg = msg ;
	}

	
	@Override
	public String toString() {
		return "ExceptionMatrice [ msg = " + msg + " ]";
	}
	
}
