package communicationReseau;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modele.Modele;

public class Serveur {
	
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String pseudoAdversaire ;
	private Thread threadReception ;
	private Modele jeu ;
	
 
	public Serveur(Modele jeu){
		
		this.jeu = jeu ;
		
		try {
			
			serverSocket = new ServerSocket(2009);
			
			socket = serverSocket.accept();
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			envoyerMessage("pseudo ?") ;
			pseudoAdversaire = in.readLine();
			
			threadReception = new Thread(new Reception(in, this)) ;
			threadReception.start() ;
			
		}
		catch (IOException e) {
			System.err.println("Le port " + serverSocket.getLocalPort()+" est déjà utilisé !");
		}
	
	}
	
	
	public String getPseudoAdversaire(){
		return pseudoAdversaire ;
	}
	
	
	public int getPvAdversaire(){
		envoyerMessage("pv ?") ;
		try {
			return Integer.parseInt(in.readLine()) ;
		}
		catch (IOException e) {
			// gerer l'exception 
		}
		catch(NumberFormatException e){
			// gerer l'exception
		}
		return -1 ;
	}
	
	
	public void envoyerMessage(String msg){
		out.println(msg) ;
		out.flush();
	}

}