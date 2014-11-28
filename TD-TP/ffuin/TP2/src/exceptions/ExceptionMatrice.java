package exceptions;

public class ExceptionMatrice extends Exception{
		
	private String s;
		
		public ExceptionMatrice(String err){
			s = err;
		}
		
		@Override
		public String toString() {
			return "Une erreur est survenue : " + s;
		}		
}
