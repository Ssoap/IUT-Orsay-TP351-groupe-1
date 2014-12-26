package modeles;

public abstract class Monstre {
	
	protected int pvActuels ;
	protected int moveSpeed ; // en cases par seconde
	protected int dps ; // dégâts par seconde
	protected Position pos ;
	protected Joueur sonMaitre ;
	
	public Monstre(){}
	
	public Monstre(int pvActuels, int moveSpeed, int dps, Position pos, Joueur sonMaitre){
		this.sonMaitre = sonMaitre ;
		this.pvActuels = pvActuels ;
		this.moveSpeed = moveSpeed ;
		this.dps = dps ;
		this.pos = pos ;
	}
	
	
	public int getPvActuels() {
		return pvActuels;
	}

	public void infligerDegats(int degats) {
		if(this.pvActuels <= degats){
			tuer() ;
		}
		else{
			this.pvActuels  -= degats;
		}
	}
	
	public void tuer(){
		sonMaitre.removeMonstre(this) ;
		/// RESEAU : Notifier la mort du monstre à l'adversaire (en envoyant les gains de destruction du monstre) ?
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void ralentir(double txRalentissement) {
		this.moveSpeed = (int)(this.moveSpeed*(1-txRalentissement));
	}

	public int getDps() {
		return dps;
	}

	public Position getPos() {
		return pos;
	}
	
}
