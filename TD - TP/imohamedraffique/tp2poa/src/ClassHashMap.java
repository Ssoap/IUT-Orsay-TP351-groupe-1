import java.util.*;
/**
 * 
 * @author imohame
 *
 */
public class ClassHashMap<T> implements BattleField<T>{

	int numLigne;
	int numColonne;
	HashMap<Integer, HashMap<Integer, T>> map;
	
	public ClassHashMap(int l, int c)
	{
		numLigne = l; //hauteur
		numColonne = c;	//largeur
		map = new HashMap<Integer,HashMap<Integer, T>>();	
	}
	/**
	 * get renvoi la valeur null si la case n'existe pas
	 * si les coordonnees passée en parametres sont en dehors de la matrice map, renvoi exception --> dans set aussi
	 */
	@Override
	public void set(int numeroLigne, int numeroColonne, T data) throws ExceptionMatrice{
		if(numeroLigne<0 || numeroLigne>numLigne || numeroColonne<0 || numeroColonne>numColonne)
		{
			throw new ExceptionMatrice("Valeur Saisie incorrect");
		}
		else 
		{
			if(map.get(numeroLigne)!=null)
			{
				if(map.get(numeroLigne).get(numeroColonne)!=null)
				{
					
					map.get(numeroLigne).put(numeroColonne, data);
				}
			}
			else 
			{
				HashMap<Integer, T> b = new HashMap<Integer, T>();
				b.put(numeroColonne, data);
				map.put(numeroLigne, b);
			}		
		}		
	}
	
	@Override
	public T get(int l, int c) throws ExceptionMatrice {
		if(l>numLigne || c>numColonne)
		{
			throw new ExceptionMatrice("ERREUR DIMENSION");
		}
		else if((map.containsKey(l))){
			if(map.get(l).get(c)!=null)
			{
				return map.get(l).get(c);
			}	
		} 
		return null;	
	}

	
	@Override
	public boolean exists(int numeroLigne, int numeroColonne) {
		if(map.get(numeroLigne)==null)
		{
			return false;
		}
		else if(map.get(numeroLigne).get(numeroColonne)!=null)
		{
			return true;
		}
		else
		{
		return false;
		}
	}

	@Override
	public int height() {
		return numLigne;
	}

	@Override
	public int width() {
		return numColonne;
	}


	
}