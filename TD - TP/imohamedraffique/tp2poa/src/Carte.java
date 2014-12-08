import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * @author Ifthihar
 *Cette classe permet de créer une map (de type HashMap) et d'y ajouter des pièces de type eau, terre et route
 */
public class Carte {

	public BattleFieldPieceWise route;
	public ClassHashMap<Integer> map = new ClassHashMap<Integer>(10,10);
	
	public Carte(BattleFieldPieceWise piece, ClassHashMap<Integer> map) {
		this.map=map;
		route=piece;
		
	}
	/**
	 * Cette méthode sert à ajouter une pièce sur une case vide d'une map (HashMap) donnée en paramètre
	 * @param piece --> La piece qui sera ajouter à la map
	 * @param map --> La map (HashMap) qui contiendra la pièce
	 * @throws ExceptionMatrice --> Une ExceptionMatrice sera lancée si les dimensions ne sont pas respectées
	 */
	public void Ajouter(BattleFieldPieceWise piece, ClassHashMap<Integer> map) throws ExceptionMatrice
	{
		if(piece.getX()<0 || piece.getX()>map.width() || piece.getY()<0 || piece.getY()>map.height())
		{
			throw new ExceptionMatrice("erreur");
		}
		else {
			if(possible(piece, map)){
				if(piece.getClass().getName().equals("BattleFieldWater"))
				{
					map.set(piece.getX(), piece.getY(), 0); //Si la piece est "eau" alors, on rajoute la valeur 0
					System.out.println("Cette case possède désormais une piece, de type " + piece.getClass().getName());
				}
				else if(piece.getClass().getName().equals("BattleFieldLandScape"))
				{
					map.set(piece.getX(), piece.getY(), 1); //Si la piece est "terre" alors, on rajoute la valeur 1
					System.out.println("Cette case possède désormais une piece, de type " + piece.getClass().getName());
				}
				else if(piece.getClass().getName().equals("BattleFieldRoad"))
				{
					map.set(piece.getX(), piece.getY(), 2); //Si la piece est "route" alors, on rajoute la valeur 2
					System.out.println("Cette case possède désormais une piece, de type " + piece.getClass().getName());
				}
			}
			else if(!possible(piece, map)){
				Integer impossible = map.get(piece.getX(), piece.getY());
				String TypePiece="";
				if(impossible == 0) TypePiece="eau";
				else if(impossible==1) TypePiece="terre";
				else if(impossible==2) TypePiece="route";
				System.out.println("Vous ne pouvez pas ajouter une piece "+piece.getClass().getName()+" car elle possède déjà une piece "+TypePiece);
			}
		}
	}
	/**
	 * Cette méthode retourne le nom de l'élement d'une pièce, c'est méthode est créée pour la fonction Construire
	 * @param pieceBase
	 * @param pieceAConstruire
	 * @param map
	 * @return
	 * @throws ExceptionMatrice
	 */
	public String nom(BattleFieldPieceWise pieceBase,BattleFieldPieceWise pieceAConstruire, ClassHashMap<Integer> map) throws ExceptionMatrice{
		String pieceB="";
		if(pieceBase.getClass().getName().equals("BattleFieldWater"))
		{
			pieceB="eau";
		}
		if(pieceBase.getClass().getName().equals("BattleFieldLandScape"))
		{
			pieceB="terre";
		}
		if(pieceBase.getClass().getName().equals("BattleFieldRoad"))
		{
			pieceB="route";
		}
		return pieceB;
	}
	/**
	 * Cette fonction permet de construire une pièce par dessus une pièce existante
	 * @param pieceBase --> La pièce par dessus laquelle sera construite la nouvelle pièce
	 * @param pieceAConstruire --> La pièce à construire par dessus la pièce pieceBase
	 * @param map --> La map (HashMap) contenant les pièces
	 * @throws ExceptionMatrice --> ExceptionMatrice lancée si les dimensions ne sont pas respéctées
	 */
	public void Construire(BattleFieldPieceWise pieceBase,BattleFieldPieceWise pieceAConstruire, ClassHashMap<Integer> map) throws ExceptionMatrice
	{
		if(pieceBase.getX()<0 || pieceBase.getX()>map.width() || pieceBase.getY()<0 || pieceBase.getY()>map.height())
		{
			throw new ExceptionMatrice("erreur");
		}
		else if(possible(pieceBase, map))
		{
			System.out.println("Impossible, il n'y a pas de piece à cette position");
		}
		
		else if(pieceBase.isCompatible(pieceAConstruire))
		{
			String pieceB = nom(pieceBase,pieceAConstruire,map);
			int TypePiece = 0;
			String piece="";
			
			
			if(pieceAConstruire.getClass().getName().equals("BattleFieldWater"))
			{
				TypePiece=0;
				piece="eau";
				map.set(pieceBase.getX(), pieceBase.getY(), TypePiece);
				System.out.println("Une piece "+piece+" a été construite par dessus une piece "+pieceB);
			}
			else if(pieceAConstruire.getClass().getName().equals("BattleFieldLandScape"))
			{
				TypePiece=1;
				piece="terre";
				map.set(pieceBase.getX(), pieceBase.getY(), TypePiece);
				System.out.println("Une piece "+piece+" a été construite par dessus une piece "+pieceB);
			}
			else if(pieceAConstruire.getClass().getName().equals("BattleFieldRoad"))
			{
				TypePiece=2;
				piece="route";
				map.set(pieceBase.getX(), pieceBase.getY(), TypePiece);
				System.out.println("Une piece "+piece+" a été construite par dessus une piece "+pieceB);
			}
			
		}
		else
		{
			System.out.println("ERREUR CONSTRUCTION, LES 2 PIECES NE SONT PAS COMPATIBLES");
		}
		
	}
	/**
	 * Cette fonction permet de savoir si on peut ou pas, ajouter ou construire une pièce dans une case de la map (HashMap)
	 * @param piece --> La pièce qui sera vérifiée, si elle peut être ajoutée ou pas sur la case de la map (HashMap) en fontion de ses coordonnées X,Y
	 * @param map --> La map (HashMap) contenant les pièces
	 * @return --> un booleen TRUE sera retournée si la case est vide, afin de pouvoir construire une pièce
	 * @throws ExceptionMatrice
	 */
	public boolean possible(BattleFieldPieceWise piece, ClassHashMap<Integer> map) throws ExceptionMatrice
	{
		if (map.get(piece.getX(), piece.getY())!=null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	/**
	 * Cette fonction permet d'afficher les pièces de la map (HashMap)
	 * @param map--> La map (HashMap) contenant les pièces qui sera affichée
	 */
	public void AfficherBattleField(ClassHashMap<Integer> map)
	{
		System.out.println(map.map);

	}
	
	public static void main(String[] args) throws ExceptionMatrice
	{
		System.out.println("Dans ce programme:");
		System.out.println("Lorsqu'une piece 'eau' est ajoutée, le hashmap contient la valeur 0");
		System.out.println("Lorsqu'une piece 'terre' est ajoutée, le hashmap contient la valeur 1");
		System.out.println("Lorsqu'une piece 'route' est ajoutée, le hashmap contient la valeur 2");
		BattleFieldRoad r = new BattleFieldRoad(5,5);
		BattleFieldWater w = new BattleFieldWater(7,4);
		BattleFieldLandScape l = new BattleFieldLandScape(1,1);
		ClassHashMap<Integer> m = new ClassHashMap<Integer>(15, 15);
		Carte c = new Carte(r,m);
		c.Ajouter(r, m);
		c.Ajouter(w, m);
		w.setX(6);
		w.setY(8);
		c.Ajouter(w, m);
		c.Construire(r, l, m); 
		c.AfficherBattleField(m);
	}
	
}
