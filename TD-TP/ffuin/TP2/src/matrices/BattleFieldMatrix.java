package matrices;

import java.util.*;
import exceptions.ExceptionMatrice;

public class BattleFieldMatrix<BattleFieldPieceWise> implements MatriceCreuseInterface{
	
	private ArrayList<ArrayList<BattleFieldPieceWise>> matrice;
	private int ligne;
	private int col;
	
	public BattleFieldMatrix(int nbl, int nbc){
		matrice = new ArrayList<ArrayList<BattleFieldPieceWise>>();
		
		for(int i=0;i<nbl;i++)
		{
		matrice.add(new ArrayList<BattleFieldPieceWise>());
			for(int j=0;j<nbc;j++)
			{
				matrice.get(i).add(null);
			}
		}
		this.ligne=nbl;
		this.col=nbc;
	}
	
	public BattleFieldPieceWise get(int numLigne, int numCol) throws ExceptionMatrice{
		if(exists(numLigne, numCol))
		{
			return matrice.get(numLigne).get(numCol);
		}else
		{
			ExceptionMatrice ex = new ExceptionMatrice("La case n'existe pas");
			throw ex;
		}
	}
	
	
	public void set(int numLigne, int numCol, BattleFieldPieceWise data)throws ExceptionMatrice{
		if(numLigne<0 || numLigne>ligne || numCol<0 || numCol>col)
		{
			ExceptionMatrice ex = new ExceptionMatrice("Valeur des colones ou ligne invalide");
			throw ex;
		}
		matrice.get(numLigne).set(numCol, data);
	}
	
	public boolean exists(int numLigne, int numCol){
		return((matrice.get(numLigne).get(numCol)) != null);
	}
	
	public int width(){
		//testMatriceCreuse
		return col;
	}
	
	public int height(){
		return ligne;
	}
}
