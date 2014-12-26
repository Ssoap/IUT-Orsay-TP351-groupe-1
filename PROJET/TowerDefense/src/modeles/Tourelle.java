package modeles;

public abstract class Tourelle {
	
	public final static int PV_INITIAUX = 100 ;
	
	protected int portee ; // en cases
	protected int dommages ; // par coup
	protected int attackSpeed ; // nombre de coups par seconde
	protected int pvActuels ;
	protected Case saCase ;
	
	public Tourelle() {}
	
	public Tourelle(int portee, int dommages, int attackSpeed){
		this.portee = portee ;
		this.dommages = dommages;
		this.attackSpeed = attackSpeed;
		this.pvActuels = PV_INITIAUX ;
	}
	
	public void placer(Case c){
		this.saCase = c ;
		if(!c.estNormale()){
			appliquerBonusSol() ;
		}
	}
	
	
	public void appliquerBonusSol(){
		if(saCase.getSonTypeSol() instanceof SolBonusAttackSpeed){
			this.attackSpeed += SolBonusAttackSpeed.BONUS ;
		}
		else if(saCase.getSonTypeSol() instanceof SolBonusPortee){
			this.portee = SolBonusPortee.BONUS ;
		}
	}
	
	
	public Case getSaCase(){
		return saCase ;
	}


	public int getPortee() {
		return portee;
	}

	
	public int getDommages() {
		return dommages;
	}


	public int getAttackSpeed() {
		return attackSpeed;
	}


	public int getPvActuels() {
		return pvActuels;
	}
	
	
	public void infligerDegats(int degats) {
		if(this.pvActuels <= degats){
			detruire() ;
		}
		else{
			this.pvActuels -= degats ;
		}
	}
	
	
	public void detruire(){
		saCase.detruireTourelle() ;
	}
	
	
	public abstract void ameliorer() ;
	
}
