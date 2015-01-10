package communicationReseau;
import java.io.BufferedReader;
import java.io.IOException;


public class Reception implements Runnable {

	private BufferedReader in;
	private Serveur serveur ;
	
	public Reception(BufferedReader in, Serveur serveur){
		this.in = in;
		this.serveur = serveur ;
	}
	
	public void run() {
		
		while(true){
	        try {
	        	System.out.println(in.readLine());
		    }
	        catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}