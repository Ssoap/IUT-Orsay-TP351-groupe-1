public class SimpleType {
/**
*
@param args the command line arguments
*/
	
public static void main(String[] args) {
	//TODO code application logic here
	byte b = java.lang.Byte.MAX_VALUE;
	int i = java.lang.Integer.MAX_VALUE;
	double d = java.lang.Double.MAX_VALUE;
	System.err.println("byte:" +b+ " / int:" +i+ " / double:" +d);
	/**
	 * la valeur maximale d'un byte: 127
	 * 			 minimale d'un byte: -128
	 * 
	 * la valeur maximale d'un Integer: 2147483647
	 * 			 minimale d'un Integer: -2147483648
	 * 
	 * la valeur maximale d'un double: 1.7976931348623157E308
	 * 		     minimale d'un double: 4.9E-324
	 */
	b++;
	i++;
	d++;
	System.err.println("byte:"+b+" / int:"+i+" / double:"+d);
	/**
	 * lorsque l'on incrémente le byte b (avec la valeur MAX), on obtient la valeur MIN_VALUE d'un byte car il y a un débordement
	 *  1111111
	 * +	  1
	 * ---------
	 * =10000000 --> -128
	 * 
	 * lorsque l'on incrémente l'Integer i (avec la valeur MAX), on obtient la valeur MIN_VALUE d'Integer car il y a un débordement
	 * c'est le même principe que pour le byte. On sait qu'un int est codé sur 32 bits, donc:
	 *  01111111 11111111 11111111 11111111
	 * +00000000 00000000 00000000 00000001
	 * ------------------------------------
	 * =10000000 00000000 00000000 00000000 --> -2147483648
	 * 
	 * lorsque l'on incrémente le double (décimal) d, on obtient la même valeur car...voila quoi 
	 * 
	 * 
	 * 
	 */
	 d-=java.lang.Double.MAX_VALUE;
	 i--;
	 b--;
	 System.err.println("byte:"+b+" / int:"+i+" / double:"+d);
	/**
	 * lorsque l'on décremente (-1) le byte b (avec la valeur MAX), on obtient la valeur MAX_VALUE d'un byte car il y a un débordement
	 *  10000000 --> -128
	 * -       1
	 * ---------
	 * =	 127
	 * 
	 * 
	 * lorsque l'on décrémente l'Integer i (avec la valeur MAX), on obtient la valeur MAX_VALUE d'Integer car il y a un débordement
	 * c'est le même principe que pour le byte. On sait qu'un int est codé sur 32 bits, donc:
	 *  10000000 00000000 00000000 00000000
	 * -00000000 00000000 00000000 00000001
	 * ------------------------------------
	 * = 2147483647 
	 * 
	 * lorsque l'on incrémente le double (décimal) d, on obtient 0 car...voila quoi
	 * 
	 * 
	 * Pour executer le programme sans IDE, il faut:
	 * 1) Copier le fichier SimpleType.java et le coller dans le bureau
	 * 2) Ouvrir cmd 
	 * 3) Se placer dans le bureau e utilisant la commande cd
	 * 4) Taper: "javac SimpleType.java"
	 * 5) Taper: "java SimpleType" et le résultat devrait s'afficher juste à la suite de la commande
	 * 
	 * ou
	 * 
	 * 1) Copier directement le fichier SimpleType.class du projet
	 * 2) Le coller sur le bureau
	 * 3) Ouvrir cmd - se placer dans le bureau et taper: "java SimpleType" et le resultat s'affiche à la suite
	 */

	}
}