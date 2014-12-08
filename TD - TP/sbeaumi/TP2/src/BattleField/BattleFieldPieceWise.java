package BattleField;

public abstract class BattleFieldPieceWise {
	int x;
	int y;
	
	public BattleFieldPieceWise(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public abstract boolean isCompatible(BattleFieldPieceWise with);
	public abstract boolean isDestroyable();
}
