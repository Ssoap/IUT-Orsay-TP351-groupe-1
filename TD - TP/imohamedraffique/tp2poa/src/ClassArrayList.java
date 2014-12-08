import java.util.ArrayList;

/**
 * 
 * @author imohame
 *
 */
public class ClassArrayList<T> implements BattleField<T>{

	int numLigne;
	int numColonne;
	ArrayList<ArrayList<T>> liste;
	
	public ClassArrayList(int l, int c)
	{
		
		numLigne = l;//hauteur
		numColonne = c;//largeur
		
			liste = new ArrayList<ArrayList<T>>();
			for (int ligne = 0 ; ligne < l ; ligne++)
			{
				liste.add(new ArrayList<T>());
				for (int colonne = 0 ; colonne < c ; colonne++)
				{
					liste.get(ligne).add(null);
				}
			}
		}
	
	public int height()
	{
		return numLigne;
	}
	
	@Override
	public int width() {
		return numColonne;
	}

	@Override
	public T get(int l, int c) throws ExceptionMatrice {
		
		if(l>numColonne || c>numLigne)
		{
			throw new ExceptionMatrice("TAILLE INCORRECTE");}
		else if(!exists(l,c)){
			throw new ExceptionMatrice("la case n'existe pas !");
		}
		else{
			return liste.get(l).get(c);
		}
	}

	@Override
	public void set(int numeroLigne, int numeroColonne, T data) throws ExceptionMatrice {
		if(numeroLigne>numLigne || numeroColonne>numColonne || numeroLigne<0 || numeroColonne<0)
		{
			throw new ExceptionMatrice("Valeur Saisie incorrect");
		}
		else if(exists(numeroLigne,numeroColonne)) //exists(numeroLigne,numeroColonne)
		{
			throw new ExceptionMatrice("A la case" + numeroLigne+", "+numeroColonne + " se trouve: " + liste.get(numeroLigne).get(numeroColonne) );
		}
		else if(!exists(numeroLigne,numeroColonne))
		{
			liste.get(numeroLigne).set(numeroColonne, data);
		}
		
		
		}

	@Override
	public boolean exists(int numeroLigne, int numeroColonne){
		if(liste.get(numeroLigne).get(numeroColonne) != null){
			return true;
		}

		else{
			return false;
		}
	}
}
