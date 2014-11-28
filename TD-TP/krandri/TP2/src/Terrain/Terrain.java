package Terrain;

import java.util.ArrayList;

import exceptions.*;
import pieceWises.*;
import matrices.*;

public class Terrain {
	
	private ArrayList<BattleFieldMatrixHashMap<BattleFieldPieceWise>> niveaux ;
	private int height ;
	private int width ;
	private final static int NB_NIVEAUX = 2 ;
	
	public Terrain(int nbL, int nbC){
		niveaux = new ArrayList<BattleFieldMatrixHashMap<BattleFieldPieceWise>>() ;
		for(int i = 0 ; i < NB_NIVEAUX ; i++){
			niveaux.add(new BattleFieldMatrixHashMap<BattleFieldPieceWise>(nbL, nbC)) ;
		}
		height = nbL ;
		width = nbC ;
	}
	
	public void ajoutCase(BattleFieldPieceWise piece) throws ExceptionTerrain{
		
		if(piece.getX() < 0 || piece.getX() > height || piece.getY() < 0 || piece.getY() > width){
			throw new ExceptionTerrain("Depassement des bornes") ;
		}
		
			
		BattleFieldMatrixHashMap<BattleFieldPieceWise> niveau = niveaux.get(0) ;
		
		if(niveau.exists(piece.getX(), piece.getY())){
				
			if (niveau.get(piece.getX(), piece.getY()).isCompatible(piece)){
				boolean freeSlot = false ;
				int k = 1 ;
				while(!freeSlot && k < NB_NIVEAUX){
					if(!(niveaux.get(k).exists(piece.getX(), piece.getY()))){
						freeSlot = true ;
					}
					k++ ;
				}
				if(freeSlot){
					niveau = niveaux.get(k-1) ;
				}
				else{
					throw new ExceptionTerrain("Aucun slot libre") ;
				}
			}
			else{
				throw new ExceptionTerrain("ajoutCase(piece, i, j) : problème de compatibilité des niveaux ( " + piece.getClass().getName() + " incompatible avec " + niveau.get(piece.getX(), piece.getY()).getClass().getName() + " )") ;
			}
			
		}
		try{
			niveau.set(piece.getX(), piece.getY(), piece) ;
		}
		catch(ExceptionMatrice e){
			System.err.println(e);
		}
	}
	
	
	public static void main(String[] args){
		
		Terrain t = new Terrain(5, 3) ;
		
		BattleFieldLandScape ls = new BattleFieldLandScape(2, 2) ;
		BattleFieldRoad r = new BattleFieldRoad(1, 2) ;
		BattleFieldWater w = new BattleFieldWater(2, 2) ;
		try{
			t.ajoutCase(ls) ;
			t.ajoutCase(r) ;
			t.ajoutCase(w) ;
		}
		catch(ExceptionTerrain e){
			System.err.println(e);
		}
		
	}
	
}
